package org.example.kun_uz.Repository;

import org.example.kun_uz.model.EmailHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailHistoryRepo extends JpaRepository<EmailHistory, Integer> {
}
