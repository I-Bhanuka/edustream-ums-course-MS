package com.example.edustream_courseMS.exception;

public class SemesterNotFoundException extends NotFoundException {
    public SemesterNotFoundException(String courseId) {
        super("Semester not found with code: " + courseId);
    }
}
