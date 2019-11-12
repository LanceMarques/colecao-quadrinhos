package com.ihc.quadrinhosorientais.infra.editora;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.ihc.quadrinhosorientais.infra.editora.exceptions.EditoraJaCadastradaException;
import com.ihc.quadrinhosorientais.infra.editora.exceptions.EditoraNaoEncontradaException;

@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EditoraServiceTest {

	@InjectMocks
	EditoraService editoraService;

	@Mock
	EditoraRepository editoraRepository;

	@Test
	public void t01_listar_listaVazia() {

		final List<Editora> resultado = this.editoraService.listar();

		assertThat(resultado).isEmpty();

	}

	@Test
	public void t02_listar_listaPopulada() {

		final Editora editora = this.criarEditora(1, "Moderna");

		List<Editora> resultadoEsperado = Arrays.asList(editora);

		when(this.editoraRepository.findAll()).thenReturn(resultadoEsperado);

		final List<Editora> resultado = this.editoraService.listar();

		assertThat(resultado).isEqualTo(resultadoEsperado);

	}

	@Test
	public void t03_buscarPorId_editoraEncontrada() {

		final Integer idEditora = 1;

		Editora resultadoEsperado = this.criarEditora(idEditora, "Moderna");

		when(this.editoraRepository.findById(idEditora)).thenReturn(Optional.of(resultadoEsperado));

		final Editora resultado = this.editoraService.buscarPorId(idEditora);

		assertThat(resultado).isEqualTo(resultadoEsperado);

	}

	@Test
	public void t04_buscarPorId_EditoraNaoEncontradaException() {

		Integer idEditora = 1;

		try {

			this.editoraService.buscarPorId(idEditora);
			fail();

		} catch (Exception e) {

			assertThat(e).isInstanceOf(EditoraNaoEncontradaException.class);

		}

	}

	@Test
	public void t05_criar_editoraCriada() {

		Editora editora = this.criarEditora(null, "Moderna");

		Editora resultadoEsperado = this.criarEditora(1, "Moderna");

		when(editoraRepository.save(editora)).thenReturn(resultadoEsperado);

		Editora editoraSalva = this.editoraService.criar(editora);

		assertThat(editoraSalva).isEqualTo(resultadoEsperado);

	}

	@Test
	public void t06_criar_editoraJaCadastradaException() {

		Editora editora = this.criarEditora(null, "Moderna");

		Editora editoraJaCadastrada = this.criarEditora(1, "Moderna");

		when(this.editoraRepository.findByNome("Moderna")).thenReturn(Optional.of(editoraJaCadastrada));

		try {

			this.editoraService.criar(editora);
			fail();

		} catch (Exception e) {

			assertThat(e).isInstanceOf(EditoraJaCadastradaException.class);

		}

	}

	@Test
	public void t07_atualizar_editoraAtualizada() {

		final Integer id = 1;

		final Editora editora = this.criarEditora(id, "Moderna");

		final Editora editoraSalva = this.criarEditora(id, "Nova");

		when(this.editoraRepository.findById(id)).thenReturn(Optional.of(editoraSalva));

		this.editoraService.atualizar(id, editora);

		final ArgumentCaptor<Editora> editoraCaptor = ArgumentCaptor.forClass(Editora.class);

		verify(this.editoraRepository, times(1)).save(editoraCaptor.capture());

		final Editora resultado = editoraCaptor.getValue();

		assertThat(resultado).isEqualTo(resultado);

	}

	@Test
	public void t08_excluirPorId_editoraExcluida() {

		final Integer id = 1;

		final Editora editora = this.criarEditora(id, "Moderna");

		when(this.editoraRepository.findById(id)).thenReturn(Optional.of(editora));

		this.editoraService.excluirPorId(id);

		verify(editoraRepository, times(1)).delete(editora);

	}

	private Editora criarEditora(Integer id, String nome) {

		return new Editora(id, nome);

	}

}
