package com.banco_semiestrutural.Banco_semiestrutural.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banco_semiestrutural.Banco_semiestrutural.entity.Aluno;


@Repository
public interface AlunoRepository extends JpaRepository<Aluno, String> {

}
