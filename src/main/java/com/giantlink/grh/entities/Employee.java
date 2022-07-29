package com.giantlink.grh.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployeeId", nullable = false)
    private Integer id;

    @JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "team_id", nullable = false)
	private Team team;

    @JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "employee", fetch = FetchType.EAGER)
    private List<Occupation> occupations;


}
