package pe.edu.cibertec.lp2final.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Talleres {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idtaller;
	
	@Column( nullable = false , length = 100)
	private String nombre;
	
	@Column( nullable = false , length = 100)
	private String dias;

	public int getIdtaller() {
		return idtaller;
	}

	public void setIdtaller(int idtaller) {
		this.idtaller = idtaller;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDias() {
		return dias;
	}

	public void setDias(String dias) {
		this.dias = dias;
	}

	public Talleres(int idtaller, String nombre, String dias) {
		super();
		this.idtaller = idtaller;
		this.nombre = nombre;
		this.dias = dias;
	}

	public Talleres() {
		super();
	}

	public Talleres(String nombre, String dias) {
		super();
		this.nombre = nombre;
		this.dias = dias;
	}
	
	
	
	
	
}
