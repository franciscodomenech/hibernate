package com.cursocuencajava.app.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cursocuencajava.app.model.IJson;

@Entity
@Table(name="users")
public class Usuario implements Serializable, IJson {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name = "user")
	private String user;

	@Column(name = "pass")
	private String pass;
	
	@Column(name = "tipo")
	private int tipo;
	
	@OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name="preferencias", 
	    joinColumns={ @JoinColumn(name="user")},
	    inverseJoinColumns={ @JoinColumn(name="art")}
			)
	private Collection<Categoria> preferencias = new LinkedHashSet<Categoria>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public Collection<Categoria> getPreferencias() {
		return preferencias;
	}

	public void setPreferencias(Collection<Categoria> preferencias) {
		this.preferencias = preferencias;
	}

	@Override
	public String toJson() {
		StringBuilder sb = new StringBuilder();
		sb.append("{\"id\":");
		sb.append(id);
		sb.append(",\"u\":\"");
		sb.append(user);
		sb.append(",\"t\":");
		sb.append(tipo);
		if(preferencias!=null) {
			try {
				StringBuilder sbp = new StringBuilder();
				sbp.append(",\"p\":[");
				Iterator<Categoria> it = preferencias.iterator();
				boolean nofirst = false;
				while(it.hasNext()) {
					if(nofirst)
						sbp.append(",");
					else
						nofirst = true;
					sbp.append(it.next().toJson());
				}
				sbp.append("]");
				sb.append(sbp.toString());
			}catch(Exception exc) {
			}
		}
		sb.append("}");
		return sb.toString();
	}
	
	
	
	
	
}
