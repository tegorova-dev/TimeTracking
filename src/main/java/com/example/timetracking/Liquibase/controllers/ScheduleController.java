package com.example.timetracking.Liquibase.controllers;

import com.example.timetracking.Liquibase.mappers.TimeRecordMapper;
import com.example.timetracking.Liquibase.models.payload.request.DeleteTimeRecordRequest;
import com.example.timetracking.Liquibase.models.payload.request.TimeRecordRequest;
import com.example.timetracking.Liquibase.services.TimeRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/schedule")
public class ScheduleController {

    private final TimeRecordService timeRecordService;
    private final TimeRecordMapper timeRecordMapper;

    @GetMapping("/tasks")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> getTasks() {
        return ResponseEntity.ok(timeRecordService.findAll());
    }

    @PostMapping("/set_task")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void setTask(@Valid @RequestBody TimeRecordRequest timeRecordRequest) throws ParseException {
        timeRecordService.save(timeRecordMapper.requestToEntity(timeRecordRequest));
    }

//    @PutMapping("/upd_task")
//    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
//    public void updTask(@Valid @RequestBody TimeRecordRequest timeRecordRequest) {
//        Timestamp t1 = Timestamp.valueOf(timeRecordRequest.getStartDate());
//        Timestamp t2 = Timestamp.valueOf(timeRecordRequest.getEndDate());
//        timeRecordRequest.setHoursSpent(t2.getHours() - t1.getHours());
//        timeRecordService.save(timeRecordMapper.requestToEntity(timeRecordRequest));
//    }

    @PostMapping("/del_task")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void delTask(@Valid @RequestBody DeleteTimeRecordRequest deleteTimeRecordRequest) {
        timeRecordService.deleteById(deleteTimeRecordRequest.getId());
    }
}
