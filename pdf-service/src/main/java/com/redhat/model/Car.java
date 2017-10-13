package com.redhat.model;


public class Car implements java.io.Serializable{
	
	private static final long serialVersionUID = 134654522000141824L;
	private java.lang.String marca;
	private java.lang.String modelo;
	private java.lang.Integer riesgoAuto;

	public java.lang.String getMarca() {
		return marca;
	}

	public void setMarca(java.lang.String marca) {
		this.marca = marca;
	}

	public java.lang.String getModelo() {
		return modelo;
	}

	public void setModelo(java.lang.String modelo) {
		this.modelo = modelo;
	}

	public java.lang.Integer getRiesgoAuto() {
		return riesgoAuto;
	}

	public void setRiesgoAuto(java.lang.Integer riesgo) {
		this.riesgoAuto = riesgo;
	}

	public Car() {
		super();
	}
}
