package com.uway.server.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "roles")
public class Role {
	
	@Id
	@GeneratedValue
	private long role_id;
	
	@Enumerated(EnumType.STRING)
	private RoleName name;

}