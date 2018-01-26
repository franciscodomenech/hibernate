package com.cursocuencajava.app.dao;

import java.util.List;

import com.cursocuencajava.app.entities.Cursos;

public interface ICursosDAO {
	public Cursos addCurso(String name);
	public List<Cursos> cursos();
	public Cursos getCurso(int idcurso);
}
