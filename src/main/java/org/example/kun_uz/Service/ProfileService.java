package org.example.kun_uz.Service;

import org.example.kun_uz.Dto.ProfileDto;
import org.example.kun_uz.Repository.ProfileRepo;
import org.example.kun_uz.model.Profile;
import org.example.kun_uz.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProfileService {

    @Autowired
     ProfileRepo profileRepo;


    public List<Profile> getall() {
        return profileRepo.findAll();
    }

    public Profile getbyid(Integer id) {
        Optional<Profile> profileOptional = profileRepo.findById(id);
        return profileOptional.get();
    }

    public Result create(ProfileDto profileDto) {
        Profile profile = new Profile();
        profile.setName(profileDto.getName());
        profile.setSurname(profileDto.getSurname());
        profile.setEmail(profileDto.getEmail());
        profile.setPhone(profileDto.getPhone());
        profile.setPassword(profileDto.getPassword());
        profile.setCreate_date(profileDto.getCreate_date());
        profile.setPhoto_id(profileDto.getPhoto_id());
        profileRepo.save(profile);

        return new Result(true, "Profile saqlandi");
    }

    public Result update(Integer id, ProfileDto profileDto) {
        Optional<Profile> profileOptional = profileRepo.findById(id);
        if (profileOptional.isPresent()) {
            Profile profile = profileOptional.get();
            profile.setName(profileDto.getName());
            profile.setSurname(profileDto.getSurname());
            profile.setEmail(profileDto.getEmail());
            profile.setPhone(profileDto.getPhone());
            profile.setPassword(profileDto.getPassword());
            profile.setCreate_date(profileDto.getCreate_date());
            profileRepo.save(profile);

            return new Result(true, "Profile saqlandi");

        }

        return new Result(false, "Profile Updated");
    }

    public Result delete(Integer id) {
        profileRepo.deleteById(id);
        return new Result(true, "Saqlandi");
    }
}
