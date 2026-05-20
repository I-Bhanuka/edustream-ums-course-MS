package com.example.edustream_courseMS.repository;

import com.example.edustream_courseMS.entity.StudentModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudentModuleRepository extends JpaRepository<StudentModule, UUID> {
}
