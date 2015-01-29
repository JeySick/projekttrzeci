package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Narkotyk;
import com.example.jeedemo.domain.Diler;
import com.example.jeedemo.service.Kartel;
import com.example.jeedemo.service.ManagerDilowania;

@SessionScoped
@Named("kurierBean")
public class KurierDileraBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Diler diler = new Diler();
	private ListDataModel<Diler> dilerzy = new ListDataModel<Diler>();
	
	private Diler dilerToShow = new Diler();
	private ListDataModel<Narkotyk> ownedNarkotyki = new ListDataModel<Narkotyk>();


	@Inject
	private Kartel pm;
	
	@Inject
	private ManagerDilowania sm;

	public Diler getDiler() {
		return diler;
	}
	public void setDiler(Diler diler) {
		this.diler = diler;
	}
	
	public ListDataModel<Diler> getAllDiler() {
		dilerzy.setWrappedData(pm.getAllDiler());
		return dilerzy;
	}

	public ListDataModel<Narkotyk> getOwnedNarkotyki() {
		ownedNarkotyki.setWrappedData(pm.getOwnedNarkotyki(dilerToShow));
		return ownedNarkotyki;
	}
	
	// Actions
	public String addDiler() {
		pm.addDiler(diler);
		return "showPersons";
		//return null;
	}

	public String deleteDiler() {
		Diler dilerToDelete = dilerzy.getRowData();
		pm.deleteDiler(dilerToDelete);
		return null;
	}
	
	public String showDetails() {
		dilerToShow = dilerzy.getRowData();
		return "details";
	}
	
	public String disposeNarkotyk(){
		Narkotyk narkotykToDispose = ownedNarkotyki.getRowData();
		sm.disposeNarkotyk(dilerToShow, narkotykToDispose);
		return null;
	}
}
