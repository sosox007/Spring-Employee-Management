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
@Table(name = "CompanyEntity")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CompanyEntityId", nullable = false)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CompanyEntityId")
    private List<Departement> departements;


}
