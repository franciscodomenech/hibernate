package com.cursocuencajava.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cursocuencajava.app.entities.Usuario;

@Repository
public class UserDAO implements IUserDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Usuario login(String u, String p) {
		List<Usuario> results = em.createQuery("select u from Usuario u left join u.preferencias p where u.user=:user and u.pass=:pass",Usuario.class).setParameter("user", u).setParameter("pass", p).getResultList();
		if(results.size()>0)
			return results.get(0);
		else
			return null;
	}

}
