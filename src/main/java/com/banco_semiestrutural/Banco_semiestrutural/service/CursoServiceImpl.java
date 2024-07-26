package com.banco_semiestrutural.Banco_semiestrutural.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco_semiestrutural.Banco_semiestrutural.entity.Aluno;
import com.banco_semiestrutural.Banco_semiestrutural.entity.Curso;
import com.banco_semiestrutural.Banco_semiestrutural.repository.AlunoRepository;
import com.banco_semiestrutural.Banco_semiestrutural.repository.CursoRepository;


@Service
public class CursoServiceImpl implements ICursoService{

	@Autowired
	private CursoRepository repository;
	
	public void saveAll(List<Curso> dadosList) {
		
		
		repository.saveAll(dadosList);
	}

	
}
