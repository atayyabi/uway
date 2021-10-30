package com.uway.server.model.dto;

import com.uway.server.model.entity.User;
import lombok.Value;

@Value
public class AuthenticationResponse {

    String jwt;
    User user;


}
