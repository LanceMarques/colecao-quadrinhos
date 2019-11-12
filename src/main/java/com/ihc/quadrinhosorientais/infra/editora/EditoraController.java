package com.ihc.quadrinhosorientais.infra.editora;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/editoras")
public class EditoraController {

	@Autowired
	private EditoraService editoraService;

	@GetMapping
	public ResponseEntity<List<Editora>> listar() {

		final List<Editora> editoras = this.editoraService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(editoras);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Editora> buscarPorId(@PathVariable("id") final Integer id) {

		final Editora editoraSalva = this.editoraService.buscarPorId(id);
		return ResponseEntity.status(HttpStatus.OK).body(editoraSalva);

	}

	@PostMapping
	public ResponseEntity<Editora> criar(@RequestBody final Editora editora) {

		final Editora editoraSalva = this.editoraService.criar(editora);
		return ResponseEntity.status(HttpStatus.CREATED).body(editoraSalva);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Editora> atualizar(@PathVariable final Integer id, @RequestBody final Editora editora) {

		final Editora editoraAtualizada = this.editoraService.atualizar(id, editora);
		return ResponseEntity.status(HttpStatus.OK).body(editoraAtualizada);

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable final Integer id){
		
		this.editoraService.excluirPorId(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				
	}

}
