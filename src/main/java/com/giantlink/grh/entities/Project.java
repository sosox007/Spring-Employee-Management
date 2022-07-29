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

    @OneToMany(mappedBy = "project",fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Job> jobs;
}
