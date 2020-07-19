package com.prueba.bdb.dto;

import java.util.List;

import com.prueba.bdb.model.LocationParent;

public class LocationParentDTO {

    private Integer id;
	private String name;
	private Integer area;
	private List<LocationChildDTO> hijos;

	public List<LocationChildDTO> getHijos() {
		return hijos;
	}

	public void setHijos(List<LocationChildDTO> hijos) {
		this.hijos = hijos;
	}

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

	public LocationParent dtoamodelo(LocationParentDTO dto) {
		LocationParent modelo = new LocationParent();
		modelo.setId(dto.getId());
		modelo.setName(dto.getName());
		modelo.setArea(dto.getArea());
		return modelo;
	}
	
	public LocationParentDTO modeloadto(LocationParent modelo) {
		LocationParentDTO dto = new LocationParentDTO();
		dto.setId(modelo.getId());
		dto.setName(modelo.getName());
		dto.setArea(modelo.getArea());
		return dto;
	}
	
	public LocationParentDTO modeloadto(LocationParent modelo, List<LocationChildDTO> hijos) {
		LocationParentDTO dto = new LocationParentDTO();
		dto.setId(modelo.getId());
		dto.setName(modelo.getName());
		dto.setArea(modelo.getArea());
		dto.setHijos(hijos);
		return dto;
	}
}
