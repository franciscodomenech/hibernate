package com.cursocuencajava.app.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cursocuencajava.app.model.IJson;

@Entity
@Table(name="categorias")
public class Categoria implements Serializable, IJson {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ic")
	private Long ic;
	
	@Column(name = "nombre")
	private String nombre;

	public Long getIc() {
		return ic;
	}

	public void setIc(Long ic) {
		this.ic = ic;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toJson() {
		StringBuilder sb = new StringBuilder();
		sb.append("{\"id\":");
		sb.append(ic);
		sb.append(",\"n\":\"");
		sb.append(nombre);
		sb.append("\"}");
		return sb.toString();
	}

	
	
}
