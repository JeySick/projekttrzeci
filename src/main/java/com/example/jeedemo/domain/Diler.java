package com.example.jeedemo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "diler.all", query = "Select p from Diler p")
})
public class Diler {

	private Long id;

	private String przykrywka = "unknown";
	private String numerTel = "";
	private Date zwerbowany = new Date();

	private List<Narkotyk> narkotyki = new ArrayList<Narkotyk>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Size(min = 2, max = 20)
	public String getPrzykrywka() {
		return przykrywka;
	}
	public void setPrzykrywka(String przykrywka) {
		this.przykrywka = przykrywka;
	}

	@Size(min = 2)
	public String getNumerTel() {
		return numerTel;
	}
	public void setNumerTel(String numerTel) {
		this.numerTel = numerTel;
	}

	@Temporal(TemporalType.DATE)
	public Date getWerbunek() {
		return zwerbowany;
	}
	public void setWerbunek(Date werbunek) {
		this.zwerbowany = werbunek;
	}

	// Be careful here, both with lazy and eager fetch type
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Narkotyk> getNarkotyki() {
		return narkotyki;
	}
	public void setNarkotyki(List<Narkotyk> narkotyki) {
		this.narkotyki = narkotyki;
	}
}
