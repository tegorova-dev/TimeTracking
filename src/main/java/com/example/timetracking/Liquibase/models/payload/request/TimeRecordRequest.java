package com.example.timetracking.Liquibase.models.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class TimeRecordRequest {
    @NotNull
    private Long id;

    @NotNull
    private String text;

    @NotNull
    private String startDate;

    @NotNull
    private String endDate;

    @NotNull
    private String date;

    @NotNull
    private Long hoursSpent;

    @NotNull
    private Long userId;
}
