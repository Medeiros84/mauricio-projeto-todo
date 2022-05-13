package com.mauricio.todo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mauricio.todo.domain.Curso;
import com.mauricio.todo.services.CursoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/todos")
public class CursoResource {

	@Autowired
	private CursoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Curso> findById(@PathVariable Integer id) {
		Curso obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/open")
	public ResponseEntity<List<Curso>> listOpen() {
		List<Curso> list = service.findAllOpen();
		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/close")
	public ResponseEntity<List<Curso>> listClose() {
		List<Curso> list = service.findAllClose();
		return ResponseEntity.ok().body(list);

	}

	@GetMapping
	public ResponseEntity<List<Curso>> listAll() {
		List<Curso> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<Curso> create(@RequestBody Curso obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.accepted().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Curso> update(@PathVariable Integer id, @RequestBody Curso obj) {
		Curso newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}

}
