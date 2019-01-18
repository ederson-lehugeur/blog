package br.com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.blog.model.Usuario;
import br.com.blog.service.UsuarioService;

@Controller
public class ModeratorController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/moderators")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("/moderators/index");
		mv.addObject("moderadores", usuarioService.findAllByRoleAdmin());
		mv.addObject("moderatorController", true);

		return mv;
	}

	@GetMapping("/moderators/new")
	public ModelAndView add(Usuario moderador) {
		ModelAndView mv = new ModelAndView("/moderators/new");
		mv.addObject("moderador", moderador);
		mv.addObject("moderatorController", true);

		return mv;
	}

	@PostMapping("/moderators/save")
	public ModelAndView save(Usuario moderador, BindingResult result) {
		if (result.hasErrors()) {
			return add(moderador);
		}

		usuarioService.saveModerator(moderador);

		return findAll();
	}

	@GetMapping("/moderators/edit")
	public ModelAndView edit(Authentication authentication) {
		Usuario moderador = usuarioService.findUsuarioByEmail(authentication.getName());

		return add(usuarioService.findUsuarioByEmail(moderador.getEmail()));
	}

	@GetMapping("/moderators/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {

		usuarioService.delete(id);

		return findAll();
	}

	@GetMapping("/moderators/edit/{id}/activate")
	public ModelAndView editActivate(@PathVariable("id") Long id) {
		Usuario moderador = usuarioService.findUsuarioById(id);

		moderador.setAtivo(true);

		usuarioService.saveModerator(moderador);

		return findAll();
	}

	@GetMapping("/moderators/edit/{id}/deactivate")
	public ModelAndView editDeactivate(@PathVariable("id") Long id) {
		Usuario moderador = usuarioService.findUsuarioById(id);

		moderador.setAtivo(false);

		usuarioService.saveModerator(moderador);

		return findAll();
	}
}
