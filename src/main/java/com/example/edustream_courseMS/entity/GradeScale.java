package com.example.edustream_courseMS.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "grade_Scale")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GradeScale {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(length = 2, nullable = false)
    private String grade;

    private double min;

    private double max;

    @Column(name = "grade_point")
    private double gradePoint;
}
