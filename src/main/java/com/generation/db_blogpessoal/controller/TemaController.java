package com.generation.db_blogpessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.db_blogpessoal.model.Tema;
import com.generation.db_blogpessoal.repository.TemaRepository;



@RestController
@RequestMapping ("/tema")
@CrossOrigin(origins = "*", allowedHeaders= "*")
public class TemaController {
	
	@Autowired
	private TemaRepository repository;
	
	
	@GetMapping
    public ResponseEntity<List<Tema>> getAll(){
	 return ResponseEntity.ok(repository.findAll());
	 
 }
	@GetMapping ("/{id}")
	public ResponseEntity<Tema> getById (@PathVariable long id){
		return repository.findById(id).map(resp ->ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
				
	}
	
	
	@GetMapping ("/nome/{nome}")
	public ResponseEntity<List<Tema>> getByName (@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Tema> post (@RequestBody Tema tema){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(tema));	
	}
		
	@DeleteMapping ("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
