package com.uway.server.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "user_test")
public class User {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long user_id;
	
	@NotNull
	@Email
	private String username;
	
	@NotNull
//	@Size(min=8, max=25)

	private String password;

	@NotNull
	@Size(min=1, max=25)
	private String fullName;

	
	@Email
	private String email;
	
	private boolean active;
	
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))	
	private Set<Role> roles = new HashSet<>();
	
	@OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.PERSIST, fetch=FetchType.LAZY)
	private List<UserAddress> userAddress = new ArrayList<UserAddress>();

}
