package com.example.jeedemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Narkotyk;
import com.example.jeedemo.domain.Diler;

@Stateless
public class Kartel {

	@PersistenceContext
	EntityManager em;

	public void addDiler(Diler diler) {
		diler.setId(null);
		em.persist(diler);
	}

	public void deleteDiler(Diler diler) {
		diler = em.find(Diler.class, diler.getId());
		em.remove(diler);
	}

	@SuppressWarnings("unchecked")
	public List<Diler> getAllDiler() {
		return em.createNamedQuery("diler.all").getResultList();
	}

	public List<Narkotyk> getOwnedNarkotyki(Diler diler) {
		diler = em.find(Diler.class, diler.getId());
		// lazy loading here - try this code without this (shallow) copying
		List<Narkotyk> narkotyki = new ArrayList<Narkotyk>(diler.getNarkotyki());
		return narkotyki;
	}

}
