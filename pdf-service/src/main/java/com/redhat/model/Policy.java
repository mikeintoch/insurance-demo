package com.redhat.model;

public class Policy {
	
	private Integer precio;
	private String  tipo;
	private Double ivaTotal;
	private Double total;
	
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Policy(Integer precio, String tipo) {
		super();
		this.precio = precio;
		this.tipo = tipo;
	}
	public Double getIvaTotal() {
		return ivaTotal;
	}
	public void setIvaTotal(Double ivaTotal) {
		this.ivaTotal = ivaTotal;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Policy() {
		super();
	}
	
	
	
}