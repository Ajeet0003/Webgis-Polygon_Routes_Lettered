package com.springrest.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springrest.entity.TblPolygon;
import java.util.Optional;
public interface PolygonDao extends JpaRepository<TblPolygon, Long> {

	Optional<TblPolygon> findByDesignation(String designation);

}
