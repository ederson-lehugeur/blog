package br.com.blog.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "post")
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "indice", sequenceName = "indice")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "indice")
	private Long id;

	@Column(nullable = false, length = 80)
	@NotBlank(message = "Autor é uma informação obrigatória.")
	private String autor;

	@Column(nullable = false, length = 160)
	@NotBlank(message = "Título é uma informação obrigatória.")
	private String titulo;

	@Column(nullable = false, length = 2000)
	@NotBlank(message = "Texto é uma informação obrigatória.")
	private String texto;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Data é uma informação obrigatória.")
	private Date data;
}
