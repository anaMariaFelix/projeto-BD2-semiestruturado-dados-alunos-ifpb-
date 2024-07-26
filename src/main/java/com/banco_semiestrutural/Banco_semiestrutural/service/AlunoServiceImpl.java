package com.banco_semiestrutural.Banco_semiestrutural.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco_semiestrutural.Banco_semiestrutural.entity.Aluno;
import com.banco_semiestrutural.Banco_semiestrutural.repository.AlunoRepository;


@Service
public class AlunoServiceImpl implements IAlunoService{

	@Autowired
	private AlunoRepository repository;
	
	public void saveAll(List<Aluno> dadosList) {
		
		
		repository.saveAll(dadosList);
	}

	
}
