package br.com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.blog.model.Usuario;
import br.com.blog.repository.ModeradorRepository;
import br.com.blog.repository.UsuarioRepository;

@Service
public class ModeradorService {
	@Autowired
	private ModeradorRepository repository;

	private UsuarioRepository usuarioRepository;

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	public Usuario findModeradorById(Long id) {
		return usuarioRepository.findUsuarioById(id);
	}

	public Usuario save(Usuario moderador) {
		return usuarioRepository.saveAndFlush(moderador);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
