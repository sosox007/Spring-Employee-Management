package com.giantlink.grh.models.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

import com.giantlink.grh.entities.CompanyEntity;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DepartementResponse {

    private Integer id;
    private String name;
    
    //Hadi t9der dir lik chi erreur ta hia hyd Response
    private CompanyEntity companyEntity;
    
    //public Set<TeamResponse> teams;
}
