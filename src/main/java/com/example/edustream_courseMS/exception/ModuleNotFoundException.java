package com.example.edustream_courseMS.exception;

public class ModuleNotFoundException extends NotFoundException {
    public ModuleNotFoundException(String courseId) {
        super("Module not found with code: " + courseId);
    }
}