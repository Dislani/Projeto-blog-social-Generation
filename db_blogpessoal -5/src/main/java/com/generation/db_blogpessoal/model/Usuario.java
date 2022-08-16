package com.generation.db_blogpessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name ="tb_usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message =" o atributo NOME é obrigatório ")
	private String nome;
	
	@NotNull (message = " O atributo usuario é obrigatório")
	@Email (message= "O atributo deve ser um email valido") // a anotação @Email não pode ser usada como atributo poius já é uma palavra reservada, por isso usamos a Strig "usuario".
	private String usuario;
	
	@NotBlank (message = " Oatributo senha é obrigartorio")
	@Size (min=8, message = "Asenha deve ter no minimo 8 caracteres")
	private String senha;
	
	
	@Size (max=5000, message= "Olink da foto não pode ser  maior que 5000 caracteres")
	private String foto;
	
	
	@OneToMany (mappedBy= "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties ("usuario")
	private List<Postagem> postagem;

	//metodos construtores
	

	public Usuario(Long id, String nome, String usuario,String senha,String foto) {
		super();
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		this.foto = foto;
	}

	public Usuario() { }
	
	/*Inserção dos Getters and Setters */

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}


	public List<Postagem> getPostagem() {
		return postagem;
	}


	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}
	
	
	

}