package org.example.kun_uz.Controller;

import org.example.kun_uz.Dto.ProfileDto;
import org.example.kun_uz.Service.ProfileService;
import org.example.kun_uz.model.Profile;
import org.example.kun_uz.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @GetMapping
    public List<Profile> getalll(){
        return profileService.getall();
    }
    @GetMapping("/{id}")
    public Profile getbyid(@PathVariable Integer id){
        return profileService.getbyid(id);
    }
    @PostMapping
    public Result create(@RequestBody ProfileDto profileDto){
        Result result=profileService.create(profileDto);
        return result;
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody ProfileDto profileDto){
        Result result=profileService.update(id, profileDto);
        return result;
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        Result result=profileService.delete(id);
        return result;
    }
}
