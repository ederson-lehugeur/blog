package br.com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.blog.model.Comentario;
import br.com.blog.repository.ComentarioRepository;

@Service
public class ComentarioService {
	@Autowired
	private ComentarioRepository repository;

	public List<Comentario> findAll() {
		return repository.findAll();
	}
	
	public List<Comentario> findAllCommentsByPostId(Long id) {
		return repository.findAllCommentsByPostId(id);
	}

	public Comentario findComentarioById(Long id) {
		return repository.findComentarioById(id);
	}

	public Comentario save(Comentario comentario) {
		return repository.saveAndFlush(comentario);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
