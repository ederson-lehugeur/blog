package br.com.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.blog.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public Usuario findUsuarioById(Long id);

	@Query(value = "SELECT * FROM usuario u INNER JOIN usuario_role ur ON u.id = ur.usuario_id "
			+ "INNER JOIN role r ON r.id = ur.role_id WHERE r.role='USER'", nativeQuery = true)
	public List<Usuario> findAllByRoleUser();

	@Query(value = "SELECT * FROM usuario u INNER JOIN usuario_role ur ON u.id = ur.usuario_id "
			+ "INNER JOIN role r ON r.id = ur.role_id WHERE r.role='ADMIN'", nativeQuery = true)
	public List<Usuario> findAllByRoleAdmin();

	public Usuario findUsuarioByEmail(String email);
}
