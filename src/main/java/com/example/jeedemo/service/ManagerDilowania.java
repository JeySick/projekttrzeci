package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Narkotyk;
import com.example.jeedemo.domain.Diler;


/* 
 * This is a Stateless EJB Bean
 * All its methods are transactional
 */
@Stateless
public class ManagerDilowania {

	@PersistenceContext
	EntityManager em;

	public void sellNarkotyk(Long dilerId, Long carId) {

		Diler diler = em.find(Diler.class, dilerId);
		Narkotyk narkotyk = em.find(Narkotyk.class, dilerId);
		narkotyk.setSold(true);

		diler.getNarkotyki().add(narkotyk);
	}

	@SuppressWarnings("unchecked")
	public List<Narkotyk> getAvailableNarkotyki() {
		return em.createNamedQuery("narkotyk.unsold").getResultList();
	}

	public void disposeNarkotyk(Diler diler, Narkotyk narkotyk) {

		diler = em.find(Diler.class, diler.getId());
		narkotyk = em.find(Narkotyk.class, narkotyk.getId());

		Narkotyk toRemove = null;
		// lazy loading here (person.getCars)
		for (Narkotyk aNarkotyk : diler.getNarkotyki())
			if (aNarkotyk.getId().compareTo(narkotyk.getId()) == 0) {
				toRemove = aNarkotyk;
				break;
			}

		if (toRemove != null)
			diler.getNarkotyki().remove(toRemove);
		
		narkotyk.setSold(false);
	}
}
