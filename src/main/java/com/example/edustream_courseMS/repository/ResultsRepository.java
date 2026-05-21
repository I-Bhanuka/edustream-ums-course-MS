package com.example.edustream_courseMS.repository;

import com.example.edustream_courseMS.entity.Results;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ResultsRepository extends JpaRepository<Results, UUID> {
}
