package com.example.timetracking.Liquibase.services;

import com.example.timetracking.Liquibase.models.entity.TimeRecord;
import com.example.timetracking.Liquibase.models.payload.request.PivotRequest;
import com.example.timetracking.Liquibase.repository.TimeRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TimeRecordService {

    private final TimeRecordRepository timeRecordRepository;

    public void save(TimeRecord timeRecord) {
        timeRecordRepository.save(timeRecord);
    }

    public void deleteById(Long id) {
        timeRecordRepository.deleteById(id);
    }

    public List<TimeRecord> findAll() {
        return timeRecordRepository.findAll();
    }

    public Optional<TimeRecord> findById(Long id) {
        return timeRecordRepository.findById(id);
    }
}