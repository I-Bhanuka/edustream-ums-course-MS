package com.example.edustream_courseMS.exception;

public class StudentNotFoundException extends NotFoundException {
    public StudentNotFoundException(String info) {
        super("Student not found with, " + info);
    }
}
