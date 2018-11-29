package br.com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.blog.model.Moderador;
import br.com.blog.model.Usuario;
import br.com.blog.repository.ModeradorRepository;
import br.com.blog.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repository;

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public Usuario findUsuarioById(Long id) {
		return repository.findUsuarioById(id);
	}

	public Usuario save(Usuario usuario) {
		return repository.saveAndFlush(usuario);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
