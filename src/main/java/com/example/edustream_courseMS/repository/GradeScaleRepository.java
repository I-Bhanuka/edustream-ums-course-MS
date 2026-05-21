package com.example.edustream_courseMS.repository;

import com.example.edustream_courseMS.dto.responseDTO.GradeAndGradePointResponseDTO;
import com.example.edustream_courseMS.entity.GradeScale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GradeScaleRepository extends JpaRepository<GradeScale, UUID> {

    Optional<GradeScale> findByGrade(String grade);

    @Query("""
    SELECT new com.example.edustream_courseMS.dto.responseDTO.GradeAndGradePointResponseDTO(
        g.grade, g.gradePoint)
    FROM GradeScale g
    WHERE :mark >= g.min AND :mark <= g.max
    """)
    GradeAndGradePointResponseDTO findGradeAndGradePointByMark(double mark);
}
