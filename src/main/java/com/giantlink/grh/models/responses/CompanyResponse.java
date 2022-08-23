package com.giantlink.grh.models.responses;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CompanyResponse {

    private Integer id;
	private String name;
    private String email;
	private String address;

	public Set<CompanyEntityResponse> entities;
    
}
