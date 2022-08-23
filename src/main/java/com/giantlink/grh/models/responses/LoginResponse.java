package com.giantlink.grh.models.responses;

import java.util.List;

import com.giantlink.grh.entities.Role;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {
	private String username;
	private String token;
	private List<String> roles;
}
