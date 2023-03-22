package com.springrest.springrest.service;

import java.util.List;

import org.locationtech.jts.io.ParseException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.springrest.springrest.dto.LetteredDto;

@Service
public interface LetteredService {

	public void addLettered(LetteredDto letteredDto) throws ParseException;

	public List<LetteredDto> getAllLettered() throws JsonMappingException, JsonProcessingException;

	public LetteredDto getOneLettered(Long letteredId) throws JsonMappingException, JsonProcessingException;

	public void updateLettered(LetteredDto letteredDto) throws ParseException;

	public boolean deleteLettered(Long letteredId);

}