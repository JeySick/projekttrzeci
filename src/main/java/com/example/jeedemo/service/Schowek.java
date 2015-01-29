package com.example.jeedemo.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Narkotyk;

@Stateless
public class Schowek {

	@PersistenceContext
	EntityManager em;

	public void addNarkotyk(Narkotyk narkotyk) {
		narkotyk.setId(null);
		em.persist(narkotyk);
	}

	public void deleteNarkotyk(Narkotyk narkotyk) {
		narkotyk = em.find(Narkotyk.class, narkotyk.getId());
		em.remove(narkotyk);
	}



}
