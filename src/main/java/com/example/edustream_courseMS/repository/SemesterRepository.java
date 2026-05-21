package com.example.edustream_courseMS.repository;

import com.example.edustream_courseMS.entity.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SemesterRepository extends JpaRepository<Semester, UUID> {
}
