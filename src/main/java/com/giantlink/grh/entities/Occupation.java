package com.giantlink.grh.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Date;

@Entity
@Table(name = "tbl_occupation")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Occupation {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOccupation;
    private boolean isCurrent;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonBackReference(value = "employee-occupation")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "job_id")
    @JsonBackReference(value = "job-occupation")
    private Job job;
    
}
