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
@Table(name = "Departement")
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DepartementId", nullable = false)
    private Long id;
    

    @OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "DepartementId")
    private List<Team> teams;
    
}
