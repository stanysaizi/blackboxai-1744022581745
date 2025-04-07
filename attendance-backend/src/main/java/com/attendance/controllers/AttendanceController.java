package com.attendance.controllers;

import com.attendance.models.Attendance;
import com.attendance.repositories.AttendanceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {
    private final AttendanceRepository attendanceRepository;

    public AttendanceController(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @PostMapping("/mark")
    public ResponseEntity<Attendance> markAttendance(@RequestBody Attendance attendance) {
        attendance.setCheckInTime(LocalDateTime.now());
        Attendance savedAttendance = attendanceRepository.save(attendance);
        return ResponseEntity.ok(savedAttendance);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getAttendance(@PathVariable Long userId) {
        // Logic to retrieve attendance records for the user
        return ResponseEntity.ok(attendanceRepository.findByUserId(userId));
    }
}