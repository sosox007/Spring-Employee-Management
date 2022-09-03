package com.giantlink.grh.models.requests;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TeamRequest {
	
	@NotNull
	@Size(min = 3, max = 20)
	private String name;
	
	@NotNull
	private Integer departement_id;
}
