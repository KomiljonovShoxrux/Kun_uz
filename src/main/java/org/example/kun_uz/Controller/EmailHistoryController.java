package org.example.kun_uz.Controller;

import org.example.kun_uz.Dto.EmailHistoryDto;
import org.example.kun_uz.Service.EmailHistoryService;
import org.example.kun_uz.model.EmailHistory;
import org.example.kun_uz.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emailhistory")
public class EmailHistoryController {

    @Autowired
    EmailHistoryService emailHistoryService;
    @GetMapping
    public List<EmailHistory> emailHistories(){
        return emailHistoryService.getAllEmailHistory();
    }
    @GetMapping("/{id}")
    public EmailHistory getEmailHistory(@PathVariable Integer id){
        return emailHistoryService.getEmailHistoryById(id);
    }
    @PostMapping
    public Result addEmailHistory(@RequestBody EmailHistoryDto emailHistoryDto){
        Result result= emailHistoryService.createEmailHistory(emailHistoryDto);
        return result;

    }

    @PutMapping("/{id}")
    public Result updateEmailHistory(@PathVariable Integer id, @RequestBody EmailHistoryDto emailHistoryDto){
        Result result= emailHistoryService.updateEmailHistory(id, emailHistoryDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result deleteEmailHistory(@PathVariable Integer id){
        Result result= emailHistoryService.deleteEmailHistory(id);
        return result;
    }
}
