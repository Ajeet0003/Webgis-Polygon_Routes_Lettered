package com.springrest.springrest.service;

import java.util.List;

import org.locationtech.jts.io.ParseException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.springrest.springrest.dto.RoutesDto;

@Service
public interface RoutesService {

	public void addAndUpdateRoutes(RoutesDto RoutesDto) throws ParseException;

	public List<RoutesDto> getAllRoutes() throws JsonMappingException, JsonProcessingException;

	public RoutesDto getOneRoutes(Long routesId) throws JsonMappingException, JsonProcessingException;

	public RoutesDto getRoutesByDesignation(String designation) throws JsonMappingException, JsonProcessingException;

	public void updateRoutes(RoutesDto RoutesDto) throws ParseException;

	public void deleteRoutes(RoutesDto routesDto) throws Exception;

}
