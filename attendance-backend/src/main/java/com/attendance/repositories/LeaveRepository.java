package com.attendance.repositories;

import com.attendance.models.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LeaveRepository extends JpaRepository<Leave, Long> {
    List<Leave> findByUserId(Long userId);
    List<Leave> findByStatus(Leave.LeaveStatus status);
    List<Leave> findByUserIdAndStatus(Long userId, Leave.LeaveStatus status);
}