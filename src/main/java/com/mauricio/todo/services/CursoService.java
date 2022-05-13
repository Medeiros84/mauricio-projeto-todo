package com.mauricio.todo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mauricio.todo.domain.Curso;
import com.mauricio.todo.repositories.CursoRepository;
import com.mauricio.todo.services.exceptions.ObjectNotFoundException;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository repository;
	
	public Curso findById(Integer id) {
		Optional<Curso> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Curso.class.getName()));
	}

	public List<Curso> findAllOpen() {
		Curso cu = new Curso();
		cu.setFinalizado(false);
		return  repository.findAll(Example.of(cu), Sort.by("dataParaFinalizar").descending());
	}

	public List<Curso> findAllClose() {
		List<Curso> list = repository.findAllClose();
		return list;
	}

	public List<Curso> findAll() {
		List<Curso> list = repository.findAll();
		return list;
	}

	public Curso create(Curso obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public Curso update(Integer id, Curso obj) {
		Curso newObj = findById(id);
		newObj.setTitulo(obj.getTitulo());
		newObj.setDataParaFinalizar(obj.getDataParaFinalizar());
		newObj.setDescricao(obj.getDescricao());
		newObj.setFinalizado(obj.getFinalizado());
		return repository.save(newObj);
	}

}
