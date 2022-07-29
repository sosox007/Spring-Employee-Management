package com.giantlink.grh.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProjectId", nullable = false)
    private Integer id;

    @JsonManagedReference    
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "project")
    private List<Job> jobs;

}
