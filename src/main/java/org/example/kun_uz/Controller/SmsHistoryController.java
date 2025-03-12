package org.example.kun_uz.Controller;

import org.example.kun_uz.Dto.SmsHistoryDto;
import org.example.kun_uz.Service.SmsHistoryService;
import org.example.kun_uz.model.Result;
import org.example.kun_uz.model.SmsHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/smshistory")
public class SmsHistoryController {

    @Autowired
    SmsHistoryService smsHistoryService;
    @GetMapping
    public List<SmsHistory> getAllSmsHistory(){
        return smsHistoryService.getall();
    }
    @GetMapping("/{id}")
    public SmsHistory getSmsHistoryById(@PathVariable Integer id){
        return smsHistoryService.getbyid(id);
    }
    @PostMapping
    public Result addSmsHistory(@RequestBody SmsHistoryDto smsHistoryDto){
        Result result = smsHistoryService.createSmsHistory(smsHistoryDto);
        return result;
    }
    @PutMapping("/{id}")
    public Result updateSmsHistory(@PathVariable Integer id , @RequestBody SmsHistoryDto smsHistoryDto){
        Result result = smsHistoryService.updateSmsHistory(id,smsHistoryDto);
        return result;
    }
    @DeleteMapping("/{id}")
    public Result deleteSmsHistory(@PathVariable Integer id){
        Result result = smsHistoryService.deleteSmsHistory(id);
        return result;
    }
}
