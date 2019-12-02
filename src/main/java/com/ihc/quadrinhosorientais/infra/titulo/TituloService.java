package com.ihc.quadrinhosorientais.infra.titulo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ihc.quadrinhosorientais.infra.titulo.exceptions.TituloEditoraJaCadastradoException;
import com.ihc.quadrinhosorientais.infra.titulo.exceptions.TituloNaoEncontradoException;
import com.ihc.quadrinhosorientais.infra.titulo.exceptions.TituloQuadrinhoAssociadoException;

@Service
public class TituloService {

  @Autowired
  private TituloRepository tituloRepository;

  public List<Titulo> listar() {
    return this.tituloRepository.findAll();
  }

  public Titulo buscarPorId(final Integer id) {
    final Optional<Titulo> tituloOptional = this.tituloRepository.findById(id);
    if (!tituloOptional.isPresent()) {
      throw new TituloNaoEncontradoException();
    }
    return tituloOptional.get();
  }

  public Titulo criar(final Titulo titulo) {
    
    final String nome = titulo.getTitulo();
    
    final String editora = titulo.getEditora();
    
    final Optional<Titulo> tituloOptional = this.tituloRepository.findByTituloAndEditora(nome, editora);
        
    if(tituloOptional.isPresent()) {
      
      throw new TituloEditoraJaCadastradoException();
      
    }
    
    return this.tituloRepository.save(titulo);
    
  }

  public Titulo atualizar(final Integer id, final Titulo titulo) {
    final Titulo tituloSalvo = this.buscarPorId(id);
    BeanUtils.copyProperties(titulo, tituloSalvo, "id");
    return this.tituloRepository.save(tituloSalvo);
  }

  public void avaliar(final Integer id, final Integer avaliacao) {

    final Titulo titulo = this.buscarPorId(id);

    titulo.setAvaliacao(avaliacao);

    this.tituloRepository.save(titulo);

  }

  public void excluirPorId(final Integer id) {
    final Titulo tituloSalvo = this.buscarPorId(id);

    if (tituloSalvo.temQuadrinhoAssociado()) {

      throw new TituloQuadrinhoAssociadoException();

    }

    this.tituloRepository.delete(tituloSalvo);
  }

}
