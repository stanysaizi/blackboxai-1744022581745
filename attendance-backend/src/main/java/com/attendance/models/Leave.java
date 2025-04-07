package com.attendance.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Leave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    private LeaveType type;

    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;
    private LeaveStatus status;

    public enum LeaveType {
        SICK,
        ANNUAL,
        EMERGENCY
    }

    public enum LeaveStatus {
        PENDING,
        APPROVED,
        REJECTED
    }
}