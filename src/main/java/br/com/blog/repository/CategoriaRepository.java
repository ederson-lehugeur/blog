package br.com.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.blog.model.Categoria;
import br.com.blog.model.Post;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	public Categoria findCategoriaById(Long id);
}
