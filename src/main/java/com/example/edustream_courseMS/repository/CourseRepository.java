package com.example.edustream_courseMS.repository;

import com.example.edustream_courseMS.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {

    /**
     * Query,
     * SELECT *
     * FROM course
     * WHERE courseId = ?;
     */
    Optional<Course> findByCourseId(String courseId);
}
