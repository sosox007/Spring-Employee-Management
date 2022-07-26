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
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployeeId", nullable = false)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "EmployeeId")
    private List<Occupation> employeeOccupations;


}
