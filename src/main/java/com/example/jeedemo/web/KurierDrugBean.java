package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Narkotyk;
import com.example.jeedemo.service.Schowek;

@SessionScoped
@Named("narkoBean")
public class KurierDrugBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Narkotyk narkotyk = new Narkotyk();


	@Inject
	private Schowek pm;
	

	public Narkotyk getNarkotyk() {
		return narkotyk;
	}


	public void setNarkotyk(Narkotyk narkotyk) {
		this.narkotyk = narkotyk;
	}

	// Actions
	public String addNarkotyk() {
		pm.addNarkotyk(narkotyk);
		return "home";
		//return null;
	}


	

}
