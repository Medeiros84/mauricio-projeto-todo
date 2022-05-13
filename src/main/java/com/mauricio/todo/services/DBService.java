package com.mauricio.todo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mauricio.todo.domain.Curso;
import com.mauricio.todo.repositories.CursoRepository;

@Service
public class DBService {

	@Autowired
	private CursoRepository cursoRepository;

	public void instanciaBaseDeDados() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Curso t1 = new Curso(null, "Estudar", "Estudar Spring Boot 2 e Angular 11", sdf.parse("25/03/2022"), false);
		Curso t2 = new Curso(null, "Ler", "Ler livro de desebvolvimento pessoal", sdf.parse("22/03/2021"), true);
		Curso t3 = new Curso(null, "Exercicios", "Praticar exercicios fisícos", sdf.parse("21/03/2022"), false);
		Curso t4 = new Curso(null, "Meditar", "Meditar durante 30 minutos pela manhã", sdf.parse("27/03/2021"), true);
		
		cursoRepository.saveAll(Arrays.asList(t1, t2, t3, t4));
	}

}
