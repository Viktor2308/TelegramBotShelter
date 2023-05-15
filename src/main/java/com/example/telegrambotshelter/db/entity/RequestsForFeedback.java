package com.example.telegrambotshelter.db.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "requests_for_feedback")
@Data
@NoArgsConstructor
public class RequestsForFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "chat_id")
    private long chatId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "task_date_time", nullable = false)
    private LocalDateTime dateTime;

    @Column(name = "phone")
    private String phoneNumber;

    @Column(name = "is_active")
    private Boolean isActive;

    public RequestsForFeedback(long chatId) {
        this.chatId = chatId;
        this.dateTime = LocalDateTime.now();
    }

    public RequestsForFeedback(long chatId, String userName, String phoneNumber) {
        this.chatId = chatId;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.dateTime = LocalDateTime.now();
        this.isActive = true;
    }
}
