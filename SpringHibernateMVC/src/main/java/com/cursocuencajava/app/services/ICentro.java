package com.cursocuencajava.app.services;

import java.util.List;

import com.cursocuencajava.app.entities.Cursos;

public interface ICentro {
	public Cursos addCurso(String name);
	public List<Cursos> cursos();
	public Cursos getCurso(int idcurso);
}
