package com.tp.schoolproject.repository;

import com.tp.schoolproject.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
