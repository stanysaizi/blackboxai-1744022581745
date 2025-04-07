package com.attendance.repositories;

import com.attendance.models.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByUserIdAndCheckInTimeBetween(Long userId, LocalDate startDate, LocalDate endDate);
}