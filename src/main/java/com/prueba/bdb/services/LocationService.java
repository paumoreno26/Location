package com.prueba.bdb.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.prueba.bdb.dto.LocationChildDTO;
import com.prueba.bdb.dto.LocationParentDTO;

@Component
public interface LocationService {

	LocationParentDTO saveParents(LocationParentDTO dto) throws Exception;

	List<LocationParentDTO> consultParent() throws Exception;

	LocationChildDTO save(LocationChildDTO dto) throws Exception;

	List<LocationChildDTO> consultChild(Integer parent) throws Exception;

	void deleteChild(Integer child) throws Exception;

}
