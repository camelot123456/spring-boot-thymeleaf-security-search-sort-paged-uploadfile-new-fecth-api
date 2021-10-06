package com.springboottutorials.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "[ROLE]")
public class RoleEntity {

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "NAME", columnDefinition = "nvarchar(255) not null")
	private String name;

	@Column(name = "CODE", columnDefinition = "varchar(255) not null unique")
	private String code;

	@ManyToMany(mappedBy = "roles")
	private List<AccountEntity> accounts = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<AccountEntity> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountEntity> accounts) {
		this.accounts = accounts;
	}

}
