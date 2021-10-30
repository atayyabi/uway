package com.uway.server.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;


@Data
@NoArgsConstructor
public class AuthenticationRequest {
	private String username;
	private String password;
}
