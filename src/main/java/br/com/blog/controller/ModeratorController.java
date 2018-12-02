package br.com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.blog.model.Moderador;
import br.com.blog.model.Post;
import br.com.blog.service.ModeradorService;

@Controller
public class ModeratorController {
	@Autowired
	private ModeradorService moderadorService;

	@GetMapping("/moderators")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("/moderators/index");
		mv.addObject("moderadores", moderadorService.findAll());
		mv.addObject("moderatorController", true);

		return mv;
	}

	@GetMapping("/moderators/new")
	public ModelAndView add(Moderador moderador) {
		ModelAndView mv = new ModelAndView("/moderators/new");
		mv.addObject("moderador", moderador);
		mv.addObject("moderatorController", true);

		return mv;
	}

	@PostMapping("/moderators/save")
	public ModelAndView save(Moderador moderador, BindingResult result) {
		if (result.hasErrors()) {
			return add(moderador);
		}

		moderadorService.save(moderador);

		return findAll();
	}

	@GetMapping("/moderators/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {

		return add(moderadorService.findModeradorById(id));
	}

	@GetMapping("/moderators/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {

		moderadorService.delete(id);

		return findAll();
	}
}
