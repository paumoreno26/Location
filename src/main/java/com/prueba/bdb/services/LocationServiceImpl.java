package com.prueba.bdb.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.prueba.bdb.dto.LocationChildDTO;
import com.prueba.bdb.dto.LocationParentDTO;
import com.prueba.bdb.model.LocationChild;
import com.prueba.bdb.model.LocationParent;
import com.prueba.bdb.repository.LocationChildRepository;
import com.prueba.bdb.repository.LocationRepository;

@Component
@Service
public class LocationServiceImpl implements LocationService{
	
	@Autowired
	LocationRepository repository;
	
	@Autowired
	LocationChildRepository childRepository;

	@Override
	public LocationParentDTO saveParents(LocationParentDTO dto) throws Exception {
		LocationParent result = new LocationParent();
		try {
			result = dto.dtoamodelo(dto);
			result = repository.save(result);
		}catch (Exception e) {
			throw new Exception(e);
		}
		return new LocationParentDTO().modeloadto(result);
	}
	
	@Override
	public LocationChildDTO save(LocationChildDTO dto) throws Exception {
		LocationChild result = new LocationChild();
		try {
			result = dto.dtoamodelo(dto);
			result = childRepository.save(result);
		}catch (Exception e) {
			throw new Exception(e);
		}
		return new LocationChildDTO().modeloadto(result);
	}
	
	@Override
	public List<LocationParentDTO> consultParent() throws Exception {
		List<LocationParent> result = new ArrayList<>();
		try {
			result = repository.findAll();
		}catch (Exception e) {
			throw new Exception(e);
		}
		return result.stream().map(e -> new LocationParentDTO().modeloadto(e)).collect(Collectors.toList());
	}
	
	@Override
	public List<LocationChildDTO> consultChild(Integer parent) throws Exception {
		List<LocationChild> result = new ArrayList<>();
		try {
			result = childRepository.findChilds(parent);
		}catch (Exception e) {
			throw new Exception(e);
		}
		return result.stream().map(e -> new LocationChildDTO().modeloadto(e)).collect(Collectors.toList());
	}
	
	@Override
	public void deleteChild(Integer child) throws Exception {
		try {
			childRepository.deleteById(child);
		}catch (Exception e) {
			throw new Exception(e);
		}
	}
}
