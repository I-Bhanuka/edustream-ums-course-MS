package com.example.edustream_courseMS.repository;

import com.example.edustream_courseMS.entity.Modules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ModulesRepository extends JpaRepository<Modules, UUID> {

    Optional<Modules> findByModuleCode(String moduleCode);
}
