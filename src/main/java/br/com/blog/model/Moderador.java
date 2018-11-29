package br.com.blog.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity(name = "moderador")
public class Moderador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 80)
	@NotBlank(message = "E-mail é uma informação obrigatória.")
    private String email;

	@Column(nullable = false, length = 120)
	@NotBlank(message = "Senha é uma informação obrigatória.")
    private String senha;

	@Column(nullable = false, length = 80)
	@NotBlank(message = "Nome é uma informação obrigatória.")
    private String nome;

	@Column(nullable = false, length = 80)
	@NotBlank(message = "Sobrenome é uma informação obrigatória.")
    private String sobrenome;

	@Column(nullable = false)
	@NotBlank(message = "Ativo é uma informação obrigatória.")
    private int ativo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}
}
