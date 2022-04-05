package com.example.timetracking.models;

import com.example.timetracking.models.enums.ERole;
import com.example.timetracking.models.enums.EStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String name;

    @Column(name = "planned_time")
    private Integer plannedTime;

    @Column(name = "elapsed_time")
    private Integer elapsedTime;

    @Column(name = "beginning_date")
    private LocalDateTime beginningDate;

    @Column(name = "ending_date")
    private LocalDateTime endingDate;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private EStatus status;

    @Column(length = 200)
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}
