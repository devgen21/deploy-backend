package br.com.gen60plus.gen.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "tb_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@ApiModelProperty(example = "email@email.com.br")
	@NotNull(message = "O atributo Usuário é Obrigatório!")
	private String username;
	
	@NotNull(message = "Senha nao pode estar vazio")
	//@Size(min = 4, max = 8, message = "Minimo 4 caracteres maximo 8")
	@Column(name = "Senha")
	private String password;
	
	
	@NotNull(message = "Email nao pode estar vazio")
	@Size(min = 8, max = 100, message = "Minimo 8 caracteres maximo 200")
	@Email(message = "O atributo Usuário deve ser um email válido!")
	@Column(name = "Email")
	private String email;

	
	 @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	 @JsonIgnoreProperties("user")
	 private List<Post> post;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	
}