package com.springrest.springrest.service;

import java.util.List;
import org.locationtech.jts.io.ParseException;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.springrest.springrest.dto.PolygonDto;

@Service
public interface PolygonService {
	public void addAndUpdatePolygon(PolygonDto polygonDto) throws ParseException;
	
	public List<PolygonDto> getAllPolygon() throws JsonMappingException, JsonProcessingException;

	public PolygonDto getOnePolygon(Long polygoneId) throws JsonMappingException, JsonProcessingException;

	public PolygonDto getPolygonByDesignation(String designation) throws JsonMappingException, JsonProcessingException;

	public void updatePolygon(PolygonDto polygonDto) throws ParseException;

	public void deletePolygon(PolygonDto polygonDto) throws Exception;
}
