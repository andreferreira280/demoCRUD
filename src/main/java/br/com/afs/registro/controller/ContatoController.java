package br.com.afs.registro.controller;

import br.com.afs.registro.entities.Contato;
import br.com.afs.registro.repository.ContatoRepository;
import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "/contatos" })
public class ContatoController {
	private ContatoRepository repository;

	public ContatoController(ContatoRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public Collection<Contato> buscaTodos() {
		return repository.findAll();
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<Contato> buscarId(@PathVariable long id) {
		return repository.findById(id).map(registro -> ResponseEntity.ok().body(registro))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping()
	public Contato criaContato(@RequestBody Contato c) {
		return repository.save(c);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Contato> atualizarContato(@PathVariable("id") long id, @RequestBody Contato c) {
		return repository.findById(id).map(registro -> {
			registro.setNome(c.getNome());
			registro.setCelular(c.getCelular());
			registro.setEmail(c.getEmail());
			Contato atualizado = repository.save(registro);
			return ResponseEntity.ok().body(atualizado);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> deletaContato(@PathVariable("id") long id) {
		return repository.findById(id).map(registro -> {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
}
