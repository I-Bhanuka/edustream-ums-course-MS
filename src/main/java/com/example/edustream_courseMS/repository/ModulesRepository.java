package com.example.edustream_courseMS.repository;

import com.example.edustream_courseMS.dto.responseDTO.ModuleRequestResponseDTO;
import com.example.edustream_courseMS.entity.Modules;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ModulesRepository extends JpaRepository<Modules, UUID> {

    Optional<Modules> findByModuleCode(String moduleCode);

    @Query("""
        SELECT new com.example.edustream_courseMS.dto.responseDTO.ModuleRequestResponseDTO(
            m.moduleName,
            m.moduleCode,
            m.credit
        )
        FROM Modules m
    """)
    Page<ModuleRequestResponseDTO> findAllWithoutUUID(Pageable pageable);
}
