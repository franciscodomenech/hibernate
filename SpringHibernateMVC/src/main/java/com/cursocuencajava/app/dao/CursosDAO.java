package com.cursocuencajava.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cursocuencajava.app.HomeController;
import com.cursocuencajava.app.entities.Cursos;

@Repository
public class CursosDAO implements ICursosDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Cursos addCurso(String name) {
		HomeController.logger.error(name);
		Cursos c = new Cursos();
		c.setNombre(name);
		em.persist(c);
		em.flush();
		em.clear();
		return em.find(Cursos.class, c.getId());
	}

	@Override
	public List<Cursos> cursos() {
		//List<Cursos> results = em.createQuery("select c from Cursos c left join c.matriculas m left join asistencia a left join evaluaciones e",Cursos.class).getResultList();
		List<Cursos> results = em.createQuery("select c from Cursos c",Cursos.class).getResultList();
		return results;
	}

	@Override
	public Cursos getCurso(int idcurso) {
		return em.find(Cursos.class, idcurso);
	}
}
