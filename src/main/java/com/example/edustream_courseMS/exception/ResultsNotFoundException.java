package com.example.edustream_courseMS.exception;

public class ResultsNotFoundException extends NotFoundException{
    public  ResultsNotFoundException(String enrollmentId) {
        super("Result not found with Enrollment ID: " + enrollmentId);
    }
}
