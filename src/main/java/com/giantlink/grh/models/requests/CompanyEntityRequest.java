package com.giantlink.grh.models.requests;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.giantlink.grh.entities.Company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyEntityRequest {

	@NotNull
	@Size(min = 3, max = 20)
	private String name;
	
	//Hadi makantch commentaire ila tra chi mochkil rdha ta hia
	@NotNull
	private Integer company_id;
	
	//Hadi makantch commentaire ila tra chi mochkil rdha ta hia
	//private Company company;

}
