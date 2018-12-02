package br.com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.blog.model.Post;
import br.com.blog.service.CategoriaService;
import br.com.blog.service.ComentarioService;
import br.com.blog.service.PostService;

@Controller
public class PostController {
	@Autowired
	private PostService postService;

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private ComentarioService comentarioService;

	@GetMapping("/")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("posts", postService.findAll());
		mv.addObject("postController", true);

		return mv;
	}

	@GetMapping("/posts/{id}/comments")
	public ModelAndView findAllComments(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("/comments/show");
		mv.addObject("comentarios", comentarioService.findAllCommentsByPostId(id));
		mv.addObject("postController", true);

		return mv;
	}

	@GetMapping("/new")
	public ModelAndView add(Post post) {
		ModelAndView mv = new ModelAndView("/posts/new");
		mv.addObject("post", post);
		mv.addObject("categorias", categoriaService.findAll());
		mv.addObject("postController", true);

		return mv;
	}

	@PostMapping("/save")
	public ModelAndView save(Post post, BindingResult result) {
		if (result.hasErrors()) {
			return add(post);
		}

		postService.save(post);

		return findAll();
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {

		return add(postService.findPostById(id));
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {

		postService.delete(id);

		return findAll();
	}
}
