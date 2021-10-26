package com.springboottutorials.entity;

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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
	private List<RoleEntity> roles;

	@Transient
	public String getImagePath() {
		if (image == null) {
			return null;
		}
		return "/img/avatar/"+image;
	}

}
