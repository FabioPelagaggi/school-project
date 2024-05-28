package com.tp.schoolproject.repository;

import com.tp.schoolproject.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
