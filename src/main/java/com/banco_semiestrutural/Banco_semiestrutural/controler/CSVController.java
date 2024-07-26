package com.banco_semiestrutural.Banco_semiestrutural.controler;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.banco_semiestrutural.Banco_semiestrutural.entity.Aluno;
import com.banco_semiestrutural.Banco_semiestrutural.entity.Curso;
import com.banco_semiestrutural.Banco_semiestrutural.service.AlunoServiceImpl;
import com.banco_semiestrutural.Banco_semiestrutural.service.CursoServiceImpl;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

@Controller
public class CSVController {

	private List<Aluno> listAlunos = new ArrayList();
	private List<Curso> listCursos = new ArrayList();

	@Autowired
	private AlunoServiceImpl serviceAluno;

	@Autowired
	private CursoServiceImpl serviceCurso;

	public void createAlunos() {

		serviceAluno.saveAll(listAlunos);
	}

	@PostMapping
	public ResponseEntity createCursos() throws CsvValidationException {
		readCSV();
		serviceCurso.saveAll(listCursos);
		createAlunos();
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
		
	}

	public void readCSV() throws CsvValidationException {

		try (CSVReader reader = new CSVReader(new FileReader("C:/Users/anafe/Downloads/alunos.csv"))) {

			String[] linha;

			for (int i = 0; i < 5000; i++) {
				String[] infoCurso = new String[3];
				String[] linhaQuebrada = new String[5];

				linha = reader.readNext();

				if (linha.length < 2) {
					linhaQuebrada = linha[0].split(",");

					infoCurso = linhaQuebrada[2].split("-");

					populateAlunoCurso(linhaQuebrada, infoCurso);

				}else {
					infoCurso = linha[2].split("-");

					if (infoCurso.length == 2) {

						String[] infoCurso2 = new String[10];
					
						String id = infoCurso[0];

						infoCurso2 = infoCurso[1].split("(CAMPUS CAJAZEIRAS)");
						
						infoCurso = new String[3];
						infoCurso[0] = id;
						infoCurso[1] = infoCurso2[0];
						infoCurso[2] = "Cajazeiras (CAMPUS CAJAZEIRAS)";
					
					}
					
					populateAlunoCurso(linha, infoCurso);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public void populateAlunoCurso(String[] linha, String[] infoCurso) {
		Aluno aluno = new Aluno();
		Curso curso = new Curso();

		curso.setId(infoCurso[0].trim());
		curso.setNome(infoCurso[1]);
		curso.setCampus(infoCurso[2]);

		aluno.setNome(linha[0]);
		aluno.setMatricula(linha[1]);
		aluno.setSituacao(linha[3]);
		aluno.setCota(linha[4]);
		aluno.setCurso(curso);

		listAlunos.add(aluno);
		curso.addAluno(aluno);

		if (!listCursos.contains(curso.getId())) {
			listCursos.add(curso);
		}

	}
	
	
}
