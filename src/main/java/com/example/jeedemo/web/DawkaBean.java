package com.example.jeedemo.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Narkotyk;
import com.example.jeedemo.domain.Diler;
import com.example.jeedemo.service.Kartel;
import com.example.jeedemo.service.ManagerDilowania;

@SessionScoped
@Named("dawkaBean")
public class DawkaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ManagerDilowania sm;

	@Inject
	private Kartel pm;

	private Long narkotykId;
	private Long dilerId;
	
	public Long getNarkotykId() {
		return narkotykId;
	}
	public void setNarkotykId(Long narkotykId) {
		this.narkotykId = narkotykId;
	}
	public Long getDilerId() {
		return dilerId;
	}
	public void setDilerId(Long dilerId) {
		this.dilerId = dilerId;
	}

	public List<Narkotyk> getAvailableNarkotyki() {
		return sm.getAvailableNarkotyki();
	}

	public List<Diler> getAllDiler() {
		return pm.getAllDiler();
	}

	public String sellNarkotyk() {
		sm.sellNarkotyk(dilerId, narkotykId);
		return null;
	}
}
