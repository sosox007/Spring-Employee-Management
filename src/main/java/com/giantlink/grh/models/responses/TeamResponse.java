package com.giantlink.grh.models.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

import com.giantlink.grh.entities.CompanyEntity;
import com.giantlink.grh.entities.Departement;
import com.giantlink.grh.entities.Team;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeamResponse {

    private Integer id;
    private String name;
    private Departement departement;
}
