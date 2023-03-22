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
import com.springrest.springrest.dao.RoutesDao;
import com.springrest.springrest.dto.RoutesDto;
import com.springrest.springrest.service.RoutesService;

@RestController
@CrossOrigin("*")
public class RoutesController {

	@Autowired
	RoutesService routesService;

	@Autowired
	RoutesDao routesDao;

	@GetMapping("/home1")
	public String home() {
		return "welcome";
	}

	@PostMapping("/saveRoutes")
	public ResponseEntity<?> addAndUpdateRoutes(@RequestBody RoutesDto routesDto) throws ParseException {

		Map<String, Object> response = new HashMap<String, Object>();
		routesService.addAndUpdateRoutes(routesDto);
		response.put("message", "success");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("getAllRoutes")
	public List<RoutesDto> getAllRoutes() throws JsonMappingException, JsonProcessingException {
		List<RoutesDto> routesDtos = routesService.getAllRoutes();
		return routesDtos;
	}

	@GetMapping("getOneRoutes/{routesId}")
	public RoutesDto getOneRoutes(@PathVariable Long routesId) throws JsonMappingException, JsonProcessingException {
		RoutesDto routesDtos = routesService.getOneRoutes(routesId);
		return routesDtos;
	}

	@GetMapping("getRouteByDesignation/{designation}")
	public RoutesDto getRoutesByDesignation(@PathVariable String designation)
			throws JsonMappingException, JsonProcessingException {
		RoutesDto routesDtos = routesService.getRoutesByDesignation(designation);
		return routesDtos;
	}

	@PutMapping("/updateRoutes")
	public ResponseEntity<?> updateRoutes(@RequestBody RoutesDto routesDto) throws ParseException {

		Map<String, Object> response = new HashMap<String, Object>();
		routesService.updateRoutes(routesDto);
		response.put("message", "success");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/deleteRoutes")
	public ResponseEntity<?> deleteRoutes(@RequestBody RoutesDto routesDto) throws ParseException {
		try {
			Map<String, Object> response = new HashMap<String, Object>();

			this.routesService.deleteRoutes((routesDto));

			response.put("message", "success");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
