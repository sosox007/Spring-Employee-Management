package com.giantlink.grh.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_project")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "project",fetch = FetchType.EAGER)
    @JsonManagedReference(value = "job-project")
    private List<Job> jobs;
    
}
