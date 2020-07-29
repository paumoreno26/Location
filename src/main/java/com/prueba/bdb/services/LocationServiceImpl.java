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
public class LocationServiceImpl implements LocationService {

	@Autowired
	LocationRepository repository;

	@Autowired
	LocationChildRepository childRepository;

	@Override
	public LocationParentDTO saveParents(LocationParentDTO dto) throws Exception {
		LocationParent result = new LocationParent();
		LocationParent result1 = new LocationParent();
		try {
			result1 = repository.findName(dto.getName());
			if(result1 == null) {
			result = dto.dtoamodelo(dto);
			result = repository.save(result);
			}else {
				throw new Exception("No se puede crear porque la locacion ya existe");
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
		return new LocationParentDTO().modeloadto(result);
	}

	@Override
	public LocationChildDTO save(LocationChildDTO dto) throws Exception {
		LocationChild result = new LocationChild();
		LocationChild result1 = new LocationChild();
		try {
			result1 = childRepository.findName(dto.getName());
			if (result1 == null) {
				result = dto.dtoamodelo(dto);
				result = childRepository.save(result);
			}else {
				throw new Exception("No se puede crear porque la locacionya existe");
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
		return new LocationChildDTO().modeloadto(result);
	}

	@Override
	public List<LocationParentDTO> consultParent() throws Exception {
		List<LocationParent> result = new ArrayList<>();
		try {
			result = repository.findAll();
		} catch (Exception e) {
			throw new Exception(e);
		}
		return result.stream().map(e -> new LocationParentDTO().modeloadto(e)).collect(Collectors.toList());
	}

	@Override
	public List<LocationChildDTO> consultChild(Integer parent) throws Exception {
		List<LocationChild> result = new ArrayList<>();
		try {
			result = childRepository.findChilds(parent);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return result.stream().map(e -> new LocationChildDTO().modeloadto(e)).collect(Collectors.toList());
	}

	@Override
	public void deleteParent(Integer parent) throws Exception {
		try {
			repository.deleteById(parent);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
}
