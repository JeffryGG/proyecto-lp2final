package pe.edu.cibertec.lp2final.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Salario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idsalario;
	
	private String tipo;
	
	private String descripcion;

	public int getIdsalario() {
		return idsalario;
	}

	public void setIdsalario(int idsalario) {
		this.idsalario = idsalario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Salario() {
		super();
	}

	public Salario(int idsalario, String tipo, String descripcion) {
		super();
		this.idsalario = idsalario;
		this.tipo = tipo;
		this.descripcion = descripcion;
	}

	public Salario(int idsalario) {
		super();
		this.idsalario = idsalario;
	}

	public Salario(String tipo, String descripcion) {
		super();
		this.tipo = tipo;
		this.descripcion = descripcion;
	}
	
	
}
