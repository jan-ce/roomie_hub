package com.roomiehub.roomiehubproject.repository;

import com.roomiehub.roomiehubproject.model.DinnerPoll;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface DinnerPollRepository extends JpaRepository<DinnerPoll, Long> {

    // This method deletes responses where the createdAt date is before the specified time
    void deleteByCreatedAtBefore(LocalDateTime dateTime);
}