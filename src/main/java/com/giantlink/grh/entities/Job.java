package com.giantlink.grh.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "tbl_job")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Job {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "job", fetch = FetchType.EAGER)
    @JsonManagedReference(value = "job-occupation")
    private List<Occupation> jobOccupations;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    @JsonBackReference(value = "job-project")
    private Project project;
    
}
