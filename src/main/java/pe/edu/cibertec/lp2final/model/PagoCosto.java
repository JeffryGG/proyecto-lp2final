package pe.edu.cibertec.lp2final.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PagoCosto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpago;
	
	@Column(nullable = false, length = 100)
	private String clases;
	
	@Column(nullable = false)
	private double costo;

	public PagoCosto() {
		super();
	}

	public PagoCosto(int idpago, String clases, double costo) {
		super();
		this.idpago = idpago;
		this.clases = clases;
		this.costo = costo;
	}
	
	public PagoCosto(int idpago, String clases) {
		super();
		this.idpago = idpago;
		this.clases = clases;
	}
	
	public PagoCosto(String clases, double costo) {
		super();
		this.clases = clases;
		this.costo = costo;
	}
	
	public PagoCosto(int idpago) {
		super();
		this.idpago = idpago;
	}
	
	public PagoCosto(String clases) {
		super();
		this.clases = clases;
	}
	
	public PagoCosto(double costo) {
		super();
		this.costo = costo;
	}

	public int getIdpago() {
		return idpago;
	}

	public void setIdpago(int idpago) {
		this.idpago = idpago;
	}

	public String getClases() {
		return clases;
	}

	public void setClases(String clases) {
		this.clases = clases;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	
}
