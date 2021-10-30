package com.uway.server.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users_addresses")
public class UserAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="address_id")
	private long id;
	private String street;
	private String city;
	private String state;
	private String country;
	private String zipCode;

	@ManyToOne
	@JoinColumn(name="user_id", referencedColumnName = "user_id")
	private User user;

}