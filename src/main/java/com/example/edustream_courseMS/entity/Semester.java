package com.example.edustream_courseMS.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "semester")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Semester {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(length = 6, nullable = false)
    private String name;

    @Column(nullable = false)
    private int year;

    @Column(name = "semester_no")
    private int semesterNo;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;
}
