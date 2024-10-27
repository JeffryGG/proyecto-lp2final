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
public class Profesor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idprofesor;
	
	@Column(nullable = false, length = 100)
	private String nombre;
	
	@Column(nullable = false, length = 100)
	private String apellido;
	
	@ManyToOne
	 @JoinColumn(name = "salario_id", referencedColumnName = "idsalario", foreignKey = @ForeignKey(name = "FK_Profesor_Salario"))
	private Salario salario;
	
	private String celular;
	
	private int dni;
	
	private String correo;
	
	private String direccion;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaini;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechafin;

	public int getIdprofesor() {
		return idprofesor;
	}

	public void setIdprofesor(int idprofesor) {
		this.idprofesor = idprofesor;
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

	public Salario getSalario() {
		return salario;
	}

	public void setSalario(Salario salario) {
		this.salario = salario;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaini() {
		return fechaini;
	}

	public void setFechaini(Date fechaini) {
		this.fechaini = fechaini;
	}

	public Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public Profesor() {
		super();
	}

	public Profesor(int idprofesor, String nombre, String apellido, Salario salario, String celular, int dni,
			String correo, String direccion, Date fechaini, Date fechafin) {
		super();
		this.idprofesor = idprofesor;
		this.nombre = nombre;
		this.apellido = apellido;
		this.salario = salario;
		this.celular = celular;
		this.dni = dni;
		this.correo = correo;
		this.direccion = direccion;
		this.fechaini = fechaini;
		this.fechafin = fechafin;
	}

	public Profesor(int idprofesor) {
		super();
		this.idprofesor = idprofesor;
	}

	public Profesor(String nombre, String apellido, Salario salario, String celular, int dni, String correo,
			String direccion, Date fechaini, Date fechafin) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.salario = salario;
		this.celular = celular;
		this.dni = dni;
		this.correo = correo;
		this.direccion = direccion;
		this.fechaini = fechaini;
		this.fechafin = fechafin;
	}
	
	
}
