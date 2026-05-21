package com.example.edustream_courseMS.exception;

public class GradeScaleNotFoundException extends NotFoundException{
    public GradeScaleNotFoundException(String grade) {
        super("Grade scale not found with grade: " + grade);
    }
}
