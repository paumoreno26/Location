package com.prueba.bdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.prueba.bdb.model.LocationChild;
import com.prueba.bdb.model.LocationParent;

public interface LocationChildRepository extends JpaRepository<LocationChild, Integer>{

	@Query(value = "select * from location_child where parent = ?1", nativeQuery = true)
	public List<LocationChild> findChilds(Integer parent);
	
	@Query(value = "select * from location_child where name = ?1", nativeQuery = true)
	public LocationChild findName(String name);
}
