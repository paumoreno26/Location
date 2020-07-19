package com.prueba.bdb.dto;

import java.util.List;

import com.prueba.bdb.model.LocationChild;
import com.prueba.bdb.model.LocationParent;

public class LocationChildDTO {

    private Integer id;
	private String name;
	private Integer area;
	private Integer parent;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

	public LocationChild dtoamodelo(LocationChildDTO dto) {
		LocationChild modelo = new LocationChild();
		modelo.setId(dto.getId());
		modelo.setName(dto.getName());
		modelo.setArea(dto.getArea());
		modelo.setParent(dto.getParent());
		return modelo;
	}
	
	public LocationChildDTO modeloadto(LocationChild modelo) {
		LocationChildDTO dto = new LocationChildDTO();
		dto.setId(modelo.getId());
		dto.setName(modelo.getName());
		dto.setArea(modelo.getArea());
		dto.setParent(modelo.getParent());
		return dto;
	}
}
