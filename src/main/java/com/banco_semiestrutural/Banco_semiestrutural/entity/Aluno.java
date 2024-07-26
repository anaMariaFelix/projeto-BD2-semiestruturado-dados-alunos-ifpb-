package com.banco_semiestrutural.Banco_semiestrutural.entity;

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
public class Aluno {

	@Id
	@Column(name = "Matricula")
	private String matricula;
	
	@Column(name = "Nome")
	private String nome;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cursoId")
	private Curso curso;
	
	@Column(name = "Situacao")
	private String situacao;
	
	@Column(name = "Cota")
	private String cota;

	@Override
	public String toString() {
		return "Aluno [matricula= " + matricula + ", nome= " + nome + ", curso= " + curso + ", situacao= " + situacao
				+ ", cota= " + cota + "]";
	}
	
	
}
