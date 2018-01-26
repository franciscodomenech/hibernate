package com.cursocuencajava.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cursocuencajava.app.dao.CursosDAO;
import com.cursocuencajava.app.entities.Cursos;

@Service
@Transactional
public class Centro implements ICentro {

	@Autowired
	private CursosDAO cursosDAO;


	@Override
	public Cursos addCurso(String name) {
		// TODO Auto-generated method stub
		return cursosDAO.addCurso(name);
	}


	@Override
	public List<Cursos> cursos() {
		// TODO Auto-generated method stub
		return cursosDAO.cursos();
	}


	@Override
	public Cursos getCurso(int idcurso) {
		// TODO Auto-generated method stub
		return cursosDAO.getCurso(idcurso);
	}

}
