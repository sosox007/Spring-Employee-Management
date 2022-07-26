package com.giantlink.grh.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Occupation")
public class Occupation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OccupationId", nullable = false)
    private Long id;

    @Column(name = "dateOccupation")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOccupation;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id", nullable = false)
    private Job  job ;

    private Boolean isCurrent;
}
