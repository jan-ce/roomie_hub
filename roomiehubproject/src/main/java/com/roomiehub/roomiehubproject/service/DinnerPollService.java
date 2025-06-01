package com.roomiehub.roomiehubproject.service;

import com.roomiehub.roomiehubproject.model.DinnerPoll;
import com.roomiehub.roomiehubproject.repository.DinnerPollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DinnerPollService {

    @Autowired
    private DinnerPollRepository dinnerPollRepository;

    // Get all responses
    public List<DinnerPoll> getAllResponses() {
        return dinnerPollRepository.findAll();
    }

    // Save a new response
    public void saveResponse(DinnerPoll entry) {
        dinnerPollRepository.save(entry);
    }

    // Reset poll daily at midnight
    @Scheduled(cron = "0 0 0 * * ?")  // Every day at midnight
    public void resetPoll() {
    	 LocalDateTime todayMidnight = LocalDateTime.now().toLocalDate().atStartOfDay();
         // Delete all responses created before today
         dinnerPollRepository.deleteByCreatedAtBefore(todayMidnight);
     }

    // Optional: For safety during GET if needed
    public boolean isNewDay() {
        return getAllResponses().stream().noneMatch(p -> p.getCreatedAt().toLocalDate().equals(java.time.LocalDate.now()));
    }
    public void deleteResponseById(Long id) {
        dinnerPollRepository.deleteById(id);
    }
}
