package br.com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import br.com.blog.model.Usuario;
import br.com.blog.service.UsuarioService;

@Controller
public class UserController {
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/users")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("/users/index");
		mv.addObject("usuarios", usuarioService.findAllByRoleUser());
		mv.addObject("userController", true);

		return mv;
	}

	@GetMapping("/users/edit/{id}/activate")
	public ModelAndView editActivate(@PathVariable("id") Long id) {
		Usuario usuario = usuarioService.findUsuarioById(id);

		usuario.setAtivo(true);

		usuarioService.saveUser(usuario);

		return findAll();
	}

	@GetMapping("/users/edit/{id}/deactivate")
	public ModelAndView editDeactivate(@PathVariable("id") Long id) {
		Usuario usuario = usuarioService.findUsuarioById(id);

		usuario.setAtivo(false);

		usuarioService.saveUser(usuario);

		return findAll();
	}
}
