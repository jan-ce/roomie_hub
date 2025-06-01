package com.roomiehub.roomiehubproject.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class DinnerPoll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String vote; // "Yes" or "No"

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public DinnerPoll() {
        this.createdAt = LocalDateTime.now();
    }

    public DinnerPoll(String name, String vote) {
        this.name = name;
        this.vote = vote;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getVote() { return vote; }
    public void setVote(String vote) { this.vote = vote; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
