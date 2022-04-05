package com.example.timetracking.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String name;

    @Column(name = "is_active")
    @Size(max = 100)
    private Boolean isActive;

    @Column(name = "beginning_date")
    private LocalDateTime beginningDate;

    @Column(name = "ending_date")
    private LocalDateTime endingDate;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Set<Task> taskSet;
}
