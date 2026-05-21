package com.example.edustream_courseMS.repository;

import com.example.edustream_courseMS.dto.responseDTO.ResultsResponseDTO;
import com.example.edustream_courseMS.entity.Results;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface ResultsRepository extends JpaRepository<Results, UUID> {

    Optional<Results> findByEnrollmentId(UUID enrollmentId);

    @Query("""
        SELECT new com.example.edustream_courseMS.dto.responseDTO.ResultsResponseDTO(
            r.enrollmentId,
            r.mark,
            r.grade,
            r.gradePoint,
            r.releasedAt
        )
        FROM Results r
        """)
    Page<ResultsResponseDTO> findAllWithoutUUID(Pageable pageable);
}
