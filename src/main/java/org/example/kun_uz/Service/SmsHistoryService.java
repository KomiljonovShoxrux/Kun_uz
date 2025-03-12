package org.example.kun_uz.Service;

import org.example.kun_uz.Dto.SmsHistoryDto;
import org.example.kun_uz.Repository.SmsHistoryRepo;
import org.example.kun_uz.model.Result;
import org.example.kun_uz.model.SmsHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SmsHistoryService {

    @Autowired
    SmsHistoryRepo smsHistoryRepo;


    public List<SmsHistory> getall(){
        return smsHistoryRepo.findAll();
    }

    public SmsHistory getbyid(Integer id){
        return smsHistoryRepo.findById(id).get();
    }

    public Result createSmsHistory(SmsHistoryDto smsHistoryDto){
        SmsHistory smsHistory = new SmsHistory();
        smsHistory.setPhone(smsHistoryDto.getPhone());
        smsHistory.setMessage(smsHistoryDto.getMessage());
        smsHistory.setType(smsHistoryDto.getType());
        smsHistoryRepo.save(smsHistory);
        return new Result(true, "Sms history Created");

    }

    public Result updateSmsHistory(Integer id , SmsHistoryDto smsHistoryDto){
        Optional<SmsHistory> smsHistory = smsHistoryRepo.findById(id);
        if(smsHistory.isPresent()){
            SmsHistory smsHistory1 = smsHistory.get();
            smsHistory1.setPhone(smsHistoryDto.getPhone());
            smsHistory1.setMessage(smsHistoryDto.getMessage());
            smsHistory1.setType(smsHistoryDto.getType());
            smsHistoryRepo.save(smsHistory1);
            return new Result(true, "Sms history Updated");

        }
        return new Result(false, "Sms history Not Found");
    }

    public Result deleteSmsHistory(Integer id){
        smsHistoryRepo.deleteById(id);
        return new Result(true, "Sms history Deleted");
    }
}
