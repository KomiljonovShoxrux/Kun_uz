package org.example.kun_uz.Controller;

import org.example.kun_uz.Dto.AttachDto;
import org.example.kun_uz.Service.AttachService;
import org.example.kun_uz.model.Attach;
import org.example.kun_uz.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attach")
public class AttachController {

    @Autowired
    AttachService attachService;

    @GetMapping
    public List<Attach> getAttach() {
        return attachService.getall();
    }
    @GetMapping("/{id}")
    public Attach getAttachById(@PathVariable Integer id) {
        return attachService.getbyid(id);
    }
    @PostMapping
    public Result addAttach(@RequestBody AttachDto attachDto) {
        Result result= attachService.createAttach(attachDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result updateAttach(@PathVariable Integer id, @RequestBody AttachDto attachDto) {
        Result result= attachService.updateAttach(id, attachDto);
        return result;
    }
    @DeleteMapping("/{id}")
    public Result deleteAttach(@PathVariable Integer id) {
        Result result= attachService.deleteAttach(id);
        return result;
    }
}
