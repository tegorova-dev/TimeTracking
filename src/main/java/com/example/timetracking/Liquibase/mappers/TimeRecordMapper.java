package com.example.timetracking.Liquibase.mappers;

import com.example.timetracking.Liquibase.models.entity.TimeRecord;
import com.example.timetracking.Liquibase.models.entity.User;
import com.example.timetracking.Liquibase.models.payload.request.PivotRequest;
import com.example.timetracking.Liquibase.models.payload.request.TimeRecordRequest;
import com.example.timetracking.Liquibase.services.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TimeRecordMapper {

    @Autowired
    private UserService userService;

    @Mapping(source = "user", target = "userId", qualifiedByName = "getUserId")
    public abstract TimeRecordRequest entityToRequest(TimeRecord timeRecord);

    @Mapping(source = "userId", target = "user", qualifiedByName = "getUserById")
    public abstract TimeRecord requestToEntity(TimeRecordRequest timeRecordRequest);


    @Mapping(source = "user", target = "username", qualifiedByName = "getUsername")
//    @Mapping(target = "hoursSpent", qualifiedByName = "getHoursSpent")
    public abstract PivotRequest entityToPivot(TimeRecord timeRecord);

    @Mapping(source = "username", target = "user", qualifiedByName = "getUserByUsername")
    public abstract TimeRecord pivotToEntity(PivotRequest pivotRequest);

    public abstract List<PivotRequest> timeRecordsToPivots(List<TimeRecord> pivots);

    public abstract List<TimeRecord> pivotsToTimeRecords(List<PivotRequest> timeRecords);


    @Named("getUserId")
    public Long getUserId(User user) {
        return user.getId();
    }

    @Named("getUserById")
    public User getUserById(Long userId) {
        return userService.getOne(userId);
    }

    @Named("getUsername")
    public String getUsername(User user) {
        return user.getUsername();
    }

    @Named("getUserByUsername")
    public User getUserByUsername(String username) {
        return userService.getByUsername(username);
    }

//    @Named("getHoursSpent")
//    public Integer getHoursSpent(TimeRecord timeRecord) {
//        Timestamp t1 = Timestamp.valueOf(timeRecord.getStartDate());
//        Timestamp t2 = Timestamp.valueOf(timeRecord.getEndDate());
//        return t2.getHours()- t1.getHours();
//    }
}
