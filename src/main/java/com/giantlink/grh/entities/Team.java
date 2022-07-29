package com.giantlink.grh.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "departement_id")
    @JsonBackReference
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Departement departement;

    @OneToMany(mappedBy = "team",fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Employee> employees;
}
