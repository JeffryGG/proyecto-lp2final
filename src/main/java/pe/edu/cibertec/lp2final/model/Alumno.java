package pe.edu.cibertec.lp2final.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.ForeignKey;


@Entity
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idalumno;
	
	@Column(nullable = false, length = 100)
	private String nombre;
	
	@Column(nullable = false, length = 200)
	private String apellido;
	
	private String dni;
	
	private int celular;
	
	@ManyToOne
	@JoinColumn(name = "pagocosto_id", referencedColumnName = "idpago", foreignKey = @ForeignKey(name = "FK_Alumno_PagoCosto"))
	private PagoCosto pagoclases;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaing;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechafin;

	
	public Alumno(String nombre, String apellido, String dni, int celular, PagoCosto pagoclases, Date fechaing,
			Date fechafin) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.celular = celular;
		this.pagoclases = pagoclases;
		this.fechaing = fechaing;
		this.fechafin = fechafin;
	}

	public Alumno() {
		super();
	}

	public Alumno(int idalumno, String nombre, String apellido, String dni, int celular, PagoCosto pagoclases,
			Date fechaing, Date fechafin) {
		super();
		this.idalumno = idalumno;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.celular = celular;
		this.pagoclases = pagoclases;
		this.fechaing = fechaing;
		this.fechafin = fechafin;
	}

	public int getIdalumno() {
		return idalumno;
	}

	public void setIdalumno(int idalumno) {
		this.idalumno = idalumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public PagoCosto getPagoclases() {
		return pagoclases;
	}

	public void setPagoclases(PagoCosto pagoclases) {
		this.pagoclases = pagoclases;
	}

	public Date getFechaing() {
		return fechaing;
	}

	public void setFechaing(Date fechaing) {
		this.fechaing = fechaing;
	}

	public Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}
	
	
}
