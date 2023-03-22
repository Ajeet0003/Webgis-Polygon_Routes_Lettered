package com.springrest.springrest.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrest.springrest.entity.TblRoutesEntity;

@Repository
public interface RoutesDao extends JpaRepository<TblRoutesEntity, Long> {

	Optional<TblRoutesEntity> findByDesignation(String designation);

}
