package com.giantlink.grh.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CompanyId", nullable = false)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CompanyId")
    private List<CompanyEntity> companyEntities;


}
