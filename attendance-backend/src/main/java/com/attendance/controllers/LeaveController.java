package com.attendance.controllers;

import com.attendance.models.Leave;
import com.attendance.repositories.LeaveRepository;
import com.attendance.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaves")
public class LeaveController {
    private final LeaveRepository leaveRepository;
    private final UserRepository userRepository;

    public LeaveController(LeaveRepository leaveRepository, UserRepository userRepository) {
        this.leaveRepository = leaveRepository;
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<Leave> createLeave(@RequestBody Leave leave) {
        return ResponseEntity.ok(leaveRepository.save(leave));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Leave>> getUserLeaves(@PathVariable Long userId) {
        return ResponseEntity.ok(leaveRepository.findByUserId(userId));
    }

    @GetMapping("/pending")
    public ResponseEntity<List<Leave>> getPendingLeaves() {
        return ResponseEntity.ok(leaveRepository.findByStatus(Leave.LeaveStatus.PENDING));
    }

    @PutMapping("/{leaveId}/approve")
    public ResponseEntity<Leave> approveLeave(@PathVariable Long leaveId) {
        return updateLeaveStatus(leaveId, Leave.LeaveStatus.APPROVED);
    }

    @PutMapping("/{leaveId}/reject")
    public ResponseEntity<Leave> rejectLeave(@PathVariable Long leaveId) {
        return updateLeaveStatus(leaveId, Leave.LeaveStatus.REJECTED);
    }

    private ResponseEntity<Leave> updateLeaveStatus(Long leaveId, Leave.LeaveStatus status) {
        return leaveRepository.findById(leaveId)
                .map(leave -> {
                    leave.setStatus(status);
                    return ResponseEntity.ok(leaveRepository.save(leave));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}