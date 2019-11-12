package com.ihc.quadrinhosorientais.infra.editora;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihc.quadrinhosorientais.infra.editora.exceptions.EditoraJaCadastradaException;
import com.ihc.quadrinhosorientais.infra.editora.exceptions.EditoraNaoEncontradaException;

@Service
public class EditoraService {

	@Autowired
	private EditoraRepository editoraRepository;

	public List<Editora> listar() {
		return this.editoraRepository.findAll();
	}

	public Editora buscarPorId(final Integer id) {
		final Optional<Editora> editoraOptional = this.editoraRepository.findById(id);
		if (!editoraOptional.isPresent()) {
			throw new EditoraNaoEncontradaException();
		}
		return editoraOptional.get();
	}

	public Editora criar(final Editora editora) {

		this.verificarExistencia(editora.getNome());

		return this.editoraRepository.save(editora);

	}

	private void verificarExistencia(String nome) {

		final Optional<Editora> editoraEncontrada = this.editoraRepository.findByNome(nome);

		if (editoraEncontrada.isPresent()) {

			throw new EditoraJaCadastradaException();

		}

	}

	public Editora atualizar(final Integer id, final Editora editora) {
		final Editora editoraSalva = this.buscarPorId(id);
		BeanUtils.copyProperties(editora, editoraSalva, "id");
		return this.editoraRepository.save(editoraSalva);
	}

	public void excluirPorId(final Integer id) {
		
		final Editora editoraSalva = this.buscarPorId(id);
		this.editoraRepository.delete(editoraSalva);
		
	}

}