package com.cursocuencajava.app.dao;

import com.cursocuencajava.app.entities.Usuario;

public interface IUserDAO {
	public Usuario login(String u,String p);
}
