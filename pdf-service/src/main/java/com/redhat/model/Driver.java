package com.redhat.model;

public class Driver {

	private Integer edad;
	private String codigoPostal;
	private String nombre;
	private String correo;
	private Integer riesgoConductor;

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Integer getRiesgoConductor() {
		return riesgoConductor;
	}

	public void setRiesgoConductor(Integer riesgo) {
		this.riesgoConductor = riesgo;
	}

	public Driver(){
		
	}
}
