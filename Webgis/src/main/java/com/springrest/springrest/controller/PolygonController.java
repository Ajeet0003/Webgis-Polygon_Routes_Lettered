package com.springrest.springrest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.locationtech.jts.io.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.springrest.springrest.dto.PolygonDto;
import com.springrest.springrest.service.PolygonService;

@RestController
@CrossOrigin("*")
public class PolygonController {
	@Autowired
	PolygonService polygonService;

	@GetMapping("/")
	public String home() {
		return "Welcome";
	}

	@PostMapping("/savePolygon")
	public ResponseEntity<?> addPolygon(@RequestBody PolygonDto polygonDto) throws ParseException {

		Map<String, Object> response = new HashMap<String, Object>();

		polygonService.addAndUpdatePolygon(polygonDto);

		response.put("message", "success");
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@GetMapping("getAllPolygon")
	public List<PolygonDto> getAllPolygon() throws JsonMappingException, JsonProcessingException {
		List<PolygonDto> polygonDtos = polygonService.getAllPolygon();
		return polygonDtos;
	}

	@GetMapping("getPolygon/{polygoneId}")
	public PolygonDto getPolygon(@PathVariable Long polygoneId) throws JsonMappingException, JsonProcessingException {
		PolygonDto polygonDtos = polygonService.getOnePolygon(polygoneId);
		return polygonDtos;
	}

	@GetMapping("getPolygonByDesignation/{designation}")
	public PolygonDto getPolygonByDesignation(@PathVariable String designation)
			throws JsonMappingException, JsonProcessingException {
		PolygonDto polygonDtos = polygonService.getPolygonByDesignation(designation);
		return polygonDtos;
	}

	@PutMapping("/updatePolygon")
	public ResponseEntity<?> updatePolygon(@RequestBody PolygonDto PolygonDto) throws ParseException {

		Map<String, Object> response = new HashMap<String, Object>();

		polygonService.updatePolygon(PolygonDto);

		response.put("message", "success");
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@DeleteMapping("/deletePolygon")
	public ResponseEntity<?> deletePolygon(@RequestBody PolygonDto polygonDto) throws ParseException {
		try {
			Map<String, Object> response = new HashMap<String, Object>();

			this.polygonService.deletePolygon(polygonDto);

			response.put("message", "success");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
