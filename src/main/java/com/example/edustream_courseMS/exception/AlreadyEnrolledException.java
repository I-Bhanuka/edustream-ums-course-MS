package com.example.edustream_courseMS.exception;

public class AlreadyEnrolledException extends ConflictException {
    public AlreadyEnrolledException(String studentId) {

        super("Student " + studentId + " is already enrolled in this course.");
    }
}
