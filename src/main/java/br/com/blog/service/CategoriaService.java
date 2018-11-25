package br.com.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.blog.model.Categoria;
import br.com.blog.model.Post;
import br.com.blog.repository.CategoriaRepository;
import br.com.blog.repository.PostRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repository;

	public List<Categoria> findAll() {
		return repository.findAll();
	}

	public Categoria findCategoriaById(Long id) {
		return repository.findCategoriaById(id);
	}

	public Categoria save(Categoria categoria) {
		return repository.saveAndFlush(categoria);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
