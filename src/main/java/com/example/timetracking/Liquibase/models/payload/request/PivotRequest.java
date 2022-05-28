package com.example.timetracking.Liquibase.models.payload.request;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Getter
@Setter
public class PivotRequest {
    @NotNull
    private String endDate;

    @NotNull
    private String startDate;

    @NotNull
    private String username;

    @NotNull
    private String date;

    @NotNull
    private Integer hoursSpent;
}
