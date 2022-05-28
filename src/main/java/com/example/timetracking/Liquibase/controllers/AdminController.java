package com.example.timetracking.Liquibase.controllers;

import com.example.timetracking.Liquibase.mappers.TimeRecordMapper;
import com.example.timetracking.Liquibase.services.TimeRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pivot")
public class AdminController {

    private final TimeRecordService timeRecordService;
    private final TimeRecordMapper timeRecordMapper;

    @GetMapping("/tasks")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getTasks() {
        System.out.println(timeRecordMapper.timeRecordsToPivots(timeRecordService.findAll()));
        return ResponseEntity.ok(timeRecordMapper.timeRecordsToPivots(timeRecordService.findAll()));
    }
}
