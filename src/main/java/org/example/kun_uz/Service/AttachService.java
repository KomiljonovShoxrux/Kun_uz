package org.example.kun_uz.Service;

import org.example.kun_uz.Dto.AttachDto;
import org.example.kun_uz.Repository.AttachRepo;
import org.example.kun_uz.model.Attach;
import org.example.kun_uz.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttachService {

    @Autowired
    AttachRepo attachRepo;


    public List<Attach> getall(){
        return attachRepo.findAll();
    }

    public Attach getbyid(Integer id){
        return attachRepo.findById(id).get();
    }

    public Result createAttach(AttachDto attachDto){
        Attach attach = new Attach();
        attach.setOrginal_name(attachDto.getOrginal_name());
        attach.setPath(attachDto.getPath());
        attach.setSize(attachDto.getSize());
        attach.setExtension(attachDto.getExtension());
        attachRepo.save(attach);
        return new Result(true, "Attach created");

    }

    public Result updateAttach( Integer id , AttachDto attachDto){
        Optional<Attach> attachOptional = attachRepo.findById(id);
        if (attachOptional.isPresent()) {
            Attach attach = attachOptional.get();
            attach.setOrginal_name(attachDto.getOrginal_name());
            attach.setPath(attachDto.getPath());
            attach.setSize(attachDto.getSize());
            attach.setExtension(attachDto.getExtension());
            attachRepo.save(attach);
            return new Result(true, "Attach updated");

        }
        return new Result(false, "Attach not found");
    }

    public Result deleteAttach(Integer id){
        attachRepo.deleteById(id);
        return new Result(true, "Attach deleted");
    }
}
