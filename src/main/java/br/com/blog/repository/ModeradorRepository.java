package br.com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.blog.model.Moderador;

@Repository
public interface ModeradorRepository extends JpaRepository<Moderador, Long> {
	public Moderador findModeradorById(Long id);
	public Moderador findModeradorByEmail(String email);
}
