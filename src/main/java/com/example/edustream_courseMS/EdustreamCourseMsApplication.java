package com.example.edustream_courseMS;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication(
		scanBasePackages = {
				"com.example.edustream_courseMS",
				"com.example.edustream_lib_common",
				"com.example.edustream_lib_security"
		}
)
public class EdustreamCourseMsApplication implements CommandLineRunner {

	@Value("${server.port}")
	private int port;

	public static void main(String[] args) {
		SpringApplication.run(EdustreamCourseMsApplication.class, args);
	}

	// To run some code after the application starts.
	@Override
	public void run(String... args) throws Exception {
		log.info("EduStream Course Microservice started");
		log.info("Course Microservice is running at http://localhost:{}", port);

	}


}
