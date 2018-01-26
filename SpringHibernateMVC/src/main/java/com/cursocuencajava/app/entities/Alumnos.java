// Generated with g9.

package com.cursocuencajava.app.entities;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="alumnos", indexes={@Index(name="alumnos_dni_IX", columnList="dni", unique=true)})
public class Alumnos implements Serializable {

    /** Primary key. */
    protected static final String PK = "id";

    /**
     * The optimistic lock. Available via standard bean get/set operations.
     */
    @Version
    @Column(name="LOCK_FLAG")
    private Integer lockFlag;

    /**
     * Access method for the lockFlag property.
     *
     * @return the current value of the lockFlag property
     */
    public Integer getLockFlag() {
        return lockFlag;
    }

    /**
     * Sets the value of the lockFlag property.
     *
     * @param aLockFlag the new value of the lockFlag property
     */
    public void setLockFlag(Integer aLockFlag) {
        lockFlag = aLockFlag;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int id;
    @Column(nullable=false, length=20)
    private String nombre;
    @Column(nullable=false, length=50)
    private String apellidos;
    @Column(unique=true, nullable=false, length=10)
    private String dni;
    @OneToMany(mappedBy="alumnos")
    private Set<Asistencia> asistencia = new LinkedHashSet<Asistencia>();
    @OneToMany(mappedBy="alumnos")
    private Set<Evaluaciones> evaluaciones = new LinkedHashSet<Evaluaciones>();
    @OneToMany(mappedBy="alumnos")
    private Set<Matriculas> matriculas = new LinkedHashSet<Matriculas>();

    /** Default constructor. */
    public Alumnos() {
        super();
    }

    /**
     * Access method for id.
     *
     * @return the current value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter method for id.
     *
     * @param aId the new value for id
     */
    public void setId(int aId) {
        id = aId;
    }

    /**
     * Access method for nombre.
     *
     * @return the current value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter method for nombre.
     *
     * @param aNombre the new value for nombre
     */
    public void setNombre(String aNombre) {
        nombre = aNombre;
    }

    /**
     * Access method for apellidos.
     *
     * @return the current value of apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Setter method for apellidos.
     *
     * @param aApellidos the new value for apellidos
     */
    public void setApellidos(String aApellidos) {
        apellidos = aApellidos;
    }

    /**
     * Access method for dni.
     *
     * @return the current value of dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * Setter method for dni.
     *
     * @param aDni the new value for dni
     */
    public void setDni(String aDni) {
        dni = aDni;
    }

    /**
     * Access method for asistencia.
     *
     * @return the current value of asistencia
     */
    public Set<Asistencia> getAsistencia() {
        return asistencia;
    }

    /**
     * Setter method for asistencia.
     *
     * @param aAsistencia the new value for asistencia
     */
    public void setAsistencia(Set<Asistencia> aAsistencia) {
        asistencia = aAsistencia;
    }

    /**
     * Access method for evaluaciones.
     *
     * @return the current value of evaluaciones
     */
    public Set<Evaluaciones> getEvaluaciones() {
        return evaluaciones;
    }

    /**
     * Setter method for evaluaciones.
     *
     * @param aEvaluaciones the new value for evaluaciones
     */
    public void setEvaluaciones(Set<Evaluaciones> aEvaluaciones) {
        evaluaciones = aEvaluaciones;
    }

    /**
     * Access method for matriculas.
     *
     * @return the current value of matriculas
     */
    public Set<Matriculas> getMatriculas() {
        return matriculas;
    }

    /**
     * Setter method for matriculas.
     *
     * @param aMatriculas the new value for matriculas
     */
    public void setMatriculas(Set<Matriculas> aMatriculas) {
        matriculas = aMatriculas;
    }

    /**
     * Compares the key for this instance with another Alumnos.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Alumnos and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Alumnos)) {
            return false;
        }
        Alumnos that = (Alumnos) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Alumnos.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Alumnos)) return false;
        return this.equalKeys(other) && ((Alumnos)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getId();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Alumnos |");
        sb.append(" id=").append(getId());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("id", new Integer(getId()));
        return ret;
    }

}
