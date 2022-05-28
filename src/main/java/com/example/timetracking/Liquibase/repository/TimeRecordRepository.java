package com.example.timetracking.Liquibase.repository;

import com.example.timetracking.Liquibase.models.entity.TimeRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRecordRepository extends JpaRepository<TimeRecord, Long> {
}
