package com.prueba.bdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.prueba.bdb.model.LocationParent;

public interface LocationRepository extends JpaRepository<LocationParent, Integer>{

}
