package com.redhat.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.redhat.model.Marca;

@ApplicationScoped
public class CatalogService {
	List<Marca> marcas;
	
	public CatalogService() {
		marcas = new ArrayList<>();
		
		marcas.add(new Marca("0001", "HONDA"));
		marcas.add(new Marca("0002", "FORD"));
		marcas.add(new Marca("0003", "BMW"));
		marcas.add(new Marca("0004", "MERCEDES"));
		marcas.add(new Marca("0005", "SEAT"));
		marcas.add(new Marca("0006", "VOLKSWAGEN"));
	}

	public List<Marca> getMarcas() {
		return marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}
}
