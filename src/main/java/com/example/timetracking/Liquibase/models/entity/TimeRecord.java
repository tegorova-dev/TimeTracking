package com.example.timetracking.Liquibase.models.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Table(name = "time_record")
public class TimeRecord {
    @Id
    private Long id;

    @Column(length = 100)
    private String text;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "hours_spent")
    private Long hoursSpent;

    @Column(name = "date")
    private String date;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
