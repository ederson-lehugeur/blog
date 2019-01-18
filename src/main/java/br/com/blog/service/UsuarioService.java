package br.com.blog.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.blog.model.Role;
import br.com.blog.model.Usuario;
import br.com.blog.repository.RoleRepository;
import br.com.blog.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository, RoleRepository roleRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.usuarioRepository = usuarioRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	public List<Usuario> findAllByRoleUser() {
		return usuarioRepository.findAllByRoleUser();
	}

	public List<Usuario> findAllByRoleAdmin() {
		return usuarioRepository.findAllByRoleAdmin();
	}

	public Usuario findUsuarioById(Long id) {
		return usuarioRepository.findUsuarioById(id);
	}

	public Usuario findUsuarioByEmail(String email) {
		return usuarioRepository.findUsuarioByEmail(email);
	}

	public Usuario saveUser(Usuario usuario) {
		usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
		Role usuarioRole = roleRepository.findByRole("USER");
		usuario.setRoles(new HashSet<Role>(Arrays.asList(usuarioRole)));

		return usuarioRepository.saveAndFlush(usuario);
	}

	public Usuario saveModerator(Usuario moderador) {
		moderador.setSenha(bCryptPasswordEncoder.encode(moderador.getSenha()));
		Role usuarioRole = roleRepository.findByRole("USER");
		Role moderadorRole = roleRepository.findByRole("ADMIN");
		moderador.setRoles(new HashSet<Role>(Arrays.asList(usuarioRole, moderadorRole)));

		return usuarioRepository.saveAndFlush(moderador);
	}

	public void delete(Long id) {
		usuarioRepository.deleteById(id);
	}
}
