package com.giantlink.grh.models.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DepartementResponse {

    private Integer id;
    private String name;
    private CompanyEntityResponse companyEntity;
    //public Set<TeamResponse> teams;
}
