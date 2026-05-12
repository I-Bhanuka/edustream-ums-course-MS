package com.example.edustream_courseMS.service.impl;

import com.example.edustream_courseMS.dto.requestDTO.RegisterCourseRequestDTO;
import com.example.edustream_courseMS.dto.responseDTO.RegisterCourseResponseDTO;
import com.example.edustream_courseMS.entity.Course;
import com.example.edustream_courseMS.enums.CourseStatus;
import com.example.edustream_courseMS.exception.CourseNotFoundException;
import com.example.edustream_courseMS.repository.CourseRepository;
import com.example.edustream_courseMS.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public String testService() {
        log.info("CourseServiceImpl: testEndpoint called");
        return "Hello from Course Microservice Service Layer!";
    }

    @Override
    public RegisterCourseResponseDTO registerCourse(RegisterCourseRequestDTO registerCourseRequestDTO) {

        log.info("================================ Registering New Course ==============================");

        log.info("Register Request details - Course Name: {}, Course Code: {}, Badge: {}, Duration(days): {}",
                 registerCourseRequestDTO.getCourseName(),
                 registerCourseRequestDTO.getCourseId(),
                 registerCourseRequestDTO.getBadge(),
                 registerCourseRequestDTO.getDurationDays());

        // Create a new Course entity with the requested data
        Course registerCourse = Course.builder()
                .courseId(registerCourseRequestDTO.getCourseId())
                .courseName(registerCourseRequestDTO.getCourseName())
                .badge(registerCourseRequestDTO.getBadge())
                .durationDays(registerCourseRequestDTO.getDurationDays())
                .courseStatus(CourseStatus.SCHEDULED)
                .build();

        // Save the new Course to the database
        log.info("Saving new Course to database with course ID: {}", registerCourse.getCourseId());
        courseRepository.save(registerCourse);

        return RegisterCourseResponseDTO.builder()
                .courseId(registerCourse.getCourseId())
                .courseName(registerCourse.getCourseName())
                .badge(registerCourse.getBadge())
                .durationDays(registerCourse.getDurationDays())
                .courseStatus(registerCourse.getCourseStatus())
                .build();
    }

    @Override
    public Page<Course> getAllCourses(Pageable pageable) {
        log.info("================================ Get All Courses Paginated ==============================");

        // Call the database to retrieve the paginated list of courses
        log.info("Retrieving courses from database with pagination - Page Number: {}, Page Size: {}, Sort: {}",
                pageable.getPageNumber(),
                pageable.getPageSize(),
                pageable.getSort());

        Page<Course> response = courseRepository.findAll(pageable);

        if (response.isEmpty()) {
            log.warn("No records were found with courses.");
            throw new CourseNotFoundException("any Id");
        }

        log.info("Retrieved Courses successfully. Total number of courses found: {}", response.getTotalElements());

        for (Course course : response) {
            log.info("Course found with Course Id: {} Course Name: {}, Course Badge: {}, Duration(days): {}, Enrolled students count: {}, Status: {}",
                    course.getCourseId(), course.getCourseName(), course.getBadge(), course.getDurationDays(),
                    course.getEnrolledStudentsCount(), course.getCourseStatus());
        }

        return response;

    }

    @Override
    public Course getCourseById(String courseId) {

        // Find a Course by courseId
        log.info("==================== Get Course by Course ID =================");

        return findCourseByCourseId(courseId);
    }

    @Override
    public Course getCourseByUUID(UUID courseUUID) {

        // Find a Course by UUID
        log.info("==================== Get Course by UUID =================");

        return findCourseByUUID(courseUUID);
    }

    @Override
    public UUID registerToCourse(String courseID) {

        // Find a Course by courseId for assignment
        log.info("==================== Get Course by Course ID For Assignment =================");
        Course course = findCourseByCourseId(courseID);

        // Increment the enrolled students count for the course
        log.info("Incrementing the enrolled students count for course with course id {}. Current enrolled students count: {}", courseID, course.getEnrolledStudentsCount());
        course.setEnrolledStudentsCount(course.getEnrolledStudentsCount() + 1);

        log.info("Increment completed. Updated enrolled students count for course with course id {}: {}", courseID, course.getEnrolledStudentsCount());

        // Save the updated course with incremented enrolled students count to the database
        log.info("Saving the updated course with incremented enrolled students count to the database");
        courseRepository.save(course);

        return course.getId();

    }



    /**
     *  ================================= Helper Methods =================================
     */

    // Helper method to find the course by courseId
    public Course findCourseByCourseId(String courseId) {
        // Find the course
        log.info("Finding course by course id {} ... ", courseId);
        Course crs = courseRepository.findByCourseId(courseId).orElse(null);

        // If course is not found, log the error and throw an exception
        if (crs == null){
            log.info("Course with courseId {} not found", courseId);
            throw new CourseNotFoundException("Id: " + courseId);
        }

        log.info("Course found with course id {}", courseId);
        return crs;
    }

    // Helper method to find the course by UUID
    public Course findCourseByUUID(UUID uuid) {
        // Find the course using the UUID
        log.info("Finding course by UUID {} ... ", uuid);
        Course crs = courseRepository.findById(uuid).orElse(null);

        if (crs == null){
            log.info("Course with UUID {} not found", uuid);
            throw new CourseNotFoundException("UUID: " + uuid);
        }

        log.info("Course found with UUID {}", uuid);
        return crs;
    }
}
