package com.redhat.model;

public class Submarcas {
	
	private String idMarca;
	private String descripcion;
	
	
	public Submarcas(String idMarca, String descripcion) {
		super();
		this.idMarca = idMarca;
		this.descripcion = descripcion;
	}
	public String getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(String idMarca) {
		this.idMarca = idMarca;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
