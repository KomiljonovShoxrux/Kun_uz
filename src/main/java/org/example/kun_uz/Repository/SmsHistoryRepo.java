package org.example.kun_uz.Repository;

import org.example.kun_uz.model.SmsHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmsHistoryRepo extends JpaRepository<SmsHistory , Integer> {
}
