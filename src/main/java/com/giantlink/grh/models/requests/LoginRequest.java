package com.giantlink.grh.models.requests;

import lombok.Data;

@Data
public class LoginRequest {
	private String username;
	private String password;
}
