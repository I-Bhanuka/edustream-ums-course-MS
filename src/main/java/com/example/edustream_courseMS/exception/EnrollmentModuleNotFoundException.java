package com.example.edustream_courseMS.exception;

public class EnrollmentModuleNotFoundException extends NotFoundException{
    public  EnrollmentModuleNotFoundException(String courseId) {
        super("Enrollment not found with code: " + courseId);
    }
}
