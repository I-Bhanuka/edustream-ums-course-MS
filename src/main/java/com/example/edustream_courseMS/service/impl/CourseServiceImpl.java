package com.example.edustream_courseMS.service.impl;

import com.example.edustream_courseMS.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    @Override
    public String testService() {
        log.info("CourseServiceImpl: testEndpoint called");
        return "Hello from Course Microservice Service Layer!";
    }
}
