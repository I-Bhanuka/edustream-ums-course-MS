package com.example.edustream_courseMS.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "results")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Results {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(name = "enrollment_id", nullable = false)
    private UUID enrollmentId;

    @Column(nullable = false)
    private double mark;

    @Column(length = 2, nullable = false)
    private String grade;

    @Column(name = "grade_point")
    private double gradePoint;

    @Column(name = "released_at", updatable = false, insertable = false)
    private LocalDate releasedAt;
}
