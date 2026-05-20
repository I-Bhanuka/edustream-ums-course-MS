package com.example.edustream_courseMS.entity;

import com.example.edustream_courseMS.enums.StudentModuleStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "student_module ")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentModule {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(name = "student_id", nullable = false)
    private UUID studentId;

    @Column(name = "module_id", nullable = false)
    private UUID module_id;

    @Column(name = "semester_id", nullable = false)
    private UUID semesterId;

    @Enumerated(EnumType.STRING)
    @Column(name = "student_module_Status", nullable = false)
    private StudentModuleStatus studentModuleStatus = StudentModuleStatus.ACTIVE;

}
