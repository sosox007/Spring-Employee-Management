package com.giantlink.grh.models.requests;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.giantlink.grh.entities.Company;
import com.giantlink.grh.entities.CompanyEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DepartementRequest {

	@NotNull
	@Size(min = 3, max = 20)
	private String name;

	//Hadi makantch commentaire ila tra chi mochkil rdha ta hia
	@NotNull
	private Integer companyEntity_id;
	
	//Hadi makantch commentaire ila tra chi mochkil rdha ta hia
	//private CompanyEntity companyEntity;
}
