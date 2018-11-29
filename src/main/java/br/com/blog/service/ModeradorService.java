package br.com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.blog.model.Moderador;
import br.com.blog.repository.ModeradorRepository;

@Service
public class ModeradorService {
	@Autowired
	private ModeradorRepository repository;

	public List<Moderador> findAll() {
		return repository.findAll();
	}

	public Moderador findModeradorById(Long id) {
		return repository.findModeradorById(id);
	}

	public Moderador save(Moderador moderador) {
		return repository.saveAndFlush(moderador);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
