package pe.edu.cibertec.lp2final.dto;

import java.util.Date;



public class UsuarioRegistroDto {
	

	private Long id;
	private String nombre;
	private String apellido;
	private Date fechanac;
	private String celular;
	private String correo;
	private String password;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Date getFechanac() {
		return fechanac;
	}
	public void setFechanac(Date fechanac) {
		this.fechanac = fechanac;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UsuarioRegistroDto(Long id, String nombre, String apellido, Date fechanac, String celular, String correo,
			String password) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechanac = fechanac;
		this.celular = celular;
		this.correo = correo;
		this.password = password;
	}
	public UsuarioRegistroDto() {
		super();
	}
	public UsuarioRegistroDto(String nombre, String apellido, Date fechanac, String celular, String correo, String password) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechanac = fechanac;
		this.celular = celular;
		this.correo = correo;
		this.password = password;
	}
	public UsuarioRegistroDto(String correo) {
		super();
		this.correo = correo;
	}

	
}
