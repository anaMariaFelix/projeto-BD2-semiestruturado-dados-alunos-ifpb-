package com.banco_semiestrutural.Banco_semiestrutural.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Data
public class Curso {

	@Id
	@Column(name = "ID")
	private String id;
	
	@Column(name = "Nome")
	private String nome;
	
	@Column(name = "Campus")
	private String campus;
	
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "curso", cascade = CascadeType.ALL)
	private List<Aluno> aluno = new ArrayList<>();
	
	public void addAluno(Aluno aluno) {
		this.aluno.add(aluno);
	}
}
