package br.com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import br.com.blog.service.ComentarioService;

@Controller
public class CommentController {
	@Autowired
	private ComentarioService comentarioService;

	@GetMapping("/comments/{id}")
	public ModelAndView findAllComments(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("/comments");
		mv.addObject("comentarios", comentarioService.findAllCommentsByPostId(id));

		return mv;
	}
}
