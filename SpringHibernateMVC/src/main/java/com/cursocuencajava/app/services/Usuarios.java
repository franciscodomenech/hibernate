package com.cursocuencajava.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cursocuencajava.app.dao.UserDAO;
import com.cursocuencajava.app.entities.Usuario;

@Service
public class Usuarios implements IUsuarios {

	@Autowired
	private UserDAO userDAO;
	
	
	@Override
	public Usuario login(String u, String p) {
		return userDAO.login(u, p);
	}

}
