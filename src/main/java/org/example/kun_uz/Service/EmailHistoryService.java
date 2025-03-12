package org.example.kun_uz.Service;

import org.example.kun_uz.Dto.EmailHistoryDto;
import org.example.kun_uz.Repository.EmailHistoryRepo;
import org.example.kun_uz.model.EmailHistory;
import org.example.kun_uz.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailHistoryService {
    @Autowired
    EmailHistoryRepo emailHistoryRepo;

    public List<EmailHistory> getAllEmailHistory() {
        return emailHistoryRepo.findAll();
    }
    public EmailHistory getEmailHistoryById(Integer id) {
        return emailHistoryRepo.findById(id).get();
    }
    public Result createEmailHistory(EmailHistoryDto emailHistoryDto) {
        EmailHistory emailHistory = new EmailHistory();
        emailHistory.setMessage(emailHistoryDto.getMessage());
        emailHistory.setEmail(emailHistoryDto.getEmail());
        emailHistoryRepo.save(emailHistory);
        return new Result(true , "Email history created");
    }

    public Result updateEmailHistory(Integer id  , EmailHistoryDto emailHistoryDto) {
        Optional<EmailHistory> emailHistoryOptional = emailHistoryRepo.findById(id);
        if (emailHistoryOptional.isPresent()) {
            EmailHistory emailHistory = emailHistoryOptional.get();
            emailHistory.setMessage(emailHistoryDto.getMessage());
            emailHistory.setEmail(emailHistoryDto.getEmail());
            emailHistoryRepo.save(emailHistory);
            return new Result(true , "Email history updated");
        }
        return new Result(false, "Email history not found");
    }
    public Result deleteEmailHistory(Integer id) {
        emailHistoryRepo.deleteById(id);
        return new Result(true , "Email history deleted");
    }
}
