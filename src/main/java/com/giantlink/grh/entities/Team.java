package com.giantlink.grh.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "tbl_team")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "departement_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference(value = "departement-team")
    private Departement departement;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "team",fetch = FetchType.EAGER)
    @JsonManagedReference(value = "team-employee")
    private List<Employee> employees;
    
}
