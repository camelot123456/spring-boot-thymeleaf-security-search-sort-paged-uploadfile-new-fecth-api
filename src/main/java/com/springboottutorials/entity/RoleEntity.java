package com.springboottutorials.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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
	private List<AccountEntity> accounts;

}
