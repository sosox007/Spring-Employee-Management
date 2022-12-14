package com.giantlink.grh.models.responses;


import com.giantlink.grh.entities.Company;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CompanyEntityResponse {

    private Integer id;
    private String name;
    
    //redha Company 3ndak tnsa azbi
    private Company company;
}
