package com.example.edustream_courseMS.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "module")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Modules {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(name = "module_code", length = 10, nullable = false, unique = true)
    private String moduleCode;

    @Column(name = "module_name", length = 50, nullable = false)
    private String moduleName;

    @Column(name = "credit")
    private int credit;
}
