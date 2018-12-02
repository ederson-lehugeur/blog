package br.com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.blog.model.Categoria;
import br.com.blog.model.Post;
import br.com.blog.service.CategoriaService;
import br.com.blog.service.ComentarioService;
import br.com.blog.service.PostService;

@Controller
public class CategoryController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/categories")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("/categories/index");
		mv.addObject("categorias", categoriaService.findAll());
		mv.addObject("categoryController", true);

		return mv;
	}

	@GetMapping("/categories/new")
	public ModelAndView add(Categoria categoria) {
		ModelAndView mv = new ModelAndView("/categories/new");
		mv.addObject("categoria", categoria);
		mv.addObject("categoryController", true);

		return mv;
	}

	@PostMapping("/categories/save")
	public ModelAndView save(Categoria categoria, BindingResult result) {
		if (result.hasErrors()) {
			return add(categoria);
		}

		categoriaService.save(categoria);

		return findAll();
	}

	@GetMapping("/categories/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {

		return add(categoriaService.findCategoriaById(id));
	}
}
