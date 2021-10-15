package com.springboottutorials.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.springboottutorials.entity.enums.EAuthenticationProvider;

@Entity
@Table(name = "ACCOUNT")
public class AccountEntity {

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "fullname", columnDefinition = "nvarchar(255) null")
	@NotBlank(message = "Trường này không được để rỗng!")
	@Size(min=2, max=40)
	private String fullname;

	@Column(name = "[IMAGE]", columnDefinition = "nvarchar(255) default N'https://friconix.com/jpg/fi-cnsuxl-question-mark.jpg'")
	private String image;
	
	@NotBlank(message = "Trường này không được để rỗng!")
	@Size(min=6, max=100, message = "Số ký tự không được nhỏ hơn 6 hoặc lớn hơn 100!")
	@Column(name = "USERNAME", columnDefinition = "varchar(255) null")
	private String username;
	
	@NotBlank(message = "Trường này không được để rỗng!")
	@Size(min=6, max=100, message = "Số ký tự không được nhỏ hơn 6 hoặc lớn hơn 100!")
	@Column(name = "[PASSWORD]", columnDefinition = "varchar(255) default '1'")
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(name = "AUTH_PROVIDER", columnDefinition = "varchar(15)")
	private EAuthenticationProvider authProvider;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "ACCOUNT_ROLE", joinColumns = @JoinColumn(name = "ID_ACCOUNT"), inverseJoinColumns = @JoinColumn(name = "ID_ROLE"))
	private List<RoleEntity> roles = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public List<RoleEntity> getRoles() {
		return roles;
	} 

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

	public EAuthenticationProvider getAuthProvider() {
		return authProvider;
	}

	public void setAuthProvider(EAuthenticationProvider authProvider) {
		this.authProvider = authProvider;
	}

	@Transient
	public String getImagePath() {
		if (image == null) {
			return null;
		}
		return "/img/avatar/"+image;
	}
	
	@Override
	public String toString() {
		return "AccountEntity [id=" + id + ", fullname=" + fullname + ", image=" + image + ", username=" + username
				+ ", password=" + password + ", authProvider=" + authProvider + ", roles=" + roles + "]";
	}
}
