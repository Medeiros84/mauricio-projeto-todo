package com.mauricio.todo.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mauricio.todo.domain.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{

	@Query("SELECT obj FROM Curso obj WHERE obj.finalizado = true ORDER BY obj.dataParaFinalizar")
	List<Curso> findAllClose();
	
}
