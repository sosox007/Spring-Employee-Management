package com.giantlink.grh.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_entity_departement")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Departement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "entity_id", nullable = false)
	private CompanyEntity companyEntity;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date timestamp;

	/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "departement")
	@JsonManagedReference
	private List<Team> teams;*/

	@PrePersist
	private void onCreate() {
		this.timestamp = new Date();
	}

}
