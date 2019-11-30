package com.ihc.quadrinhosorientais.infra.amigo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ihc.quadrinhosorientais.infra.amigo.exceptions.AmigoEmprestimoVinculadoException;
import com.ihc.quadrinhosorientais.infra.amigo.exceptions.AmigoJaCadastradoException;
import com.ihc.quadrinhosorientais.infra.amigo.exceptions.AmigoNaoEncontradoException;

@Service
public class AmigoService {

  @Autowired
  private AmigoRepository amigoRepository;

  public List<Amigo> listar() {
    return this.amigoRepository.findAll();
  }

  public Amigo buscarPorId(final Integer id) {
    final Optional<Amigo> amigoOptional = this.amigoRepository.findById(id);
    if (!amigoOptional.isPresent()) {
      throw new AmigoNaoEncontradoException();
    }
    return amigoOptional.get();
  }

  public Amigo criar(final Amigo amigo) {

    final String nome = amigo.getNome();

    final String apelido = amigo.getApelido();

    final Optional<Amigo> amigoOptional = this.amigoRepository.findByNomeAndApelido(nome, apelido);

    if (amigoOptional.isPresent()) {

      throw new AmigoJaCadastradoException();

    }

    return this.amigoRepository.save(amigo);

  }

  public Amigo atualizar(final Integer id, final Amigo amigo) {

    final String nome = amigo.getNome();

    final String apelido = amigo.getApelido();

    final Optional<Amigo> amigoOptional = this.amigoRepository.findByNomeAndApelido(nome, apelido);

    if (amigoOptional.isPresent()) {

      if (!amigoOptional.get().getId().equals(id)) {

        throw new AmigoJaCadastradoException();

      }

    }

    final Amigo amigoSalvo = this.buscarPorId(id);
    BeanUtils.copyProperties(amigo, amigoSalvo, "id");
    return this.amigoRepository.save(amigoSalvo);

  }

  public void excluirPorId(final Integer id) {

    final Amigo amigoSalvo = this.buscarPorId(id);

    if (amigoSalvo.temEmprestimoVinculado()) {

      throw new AmigoEmprestimoVinculadoException();

    }

    this.amigoRepository.delete(amigoSalvo);
  }

}
