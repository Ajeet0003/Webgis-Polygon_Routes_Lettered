package com.springrest.springrest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;

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
import com.springrest.springrest.dao.LetteredDao;
import com.springrest.springrest.dto.LetteredDto;
import com.springrest.springrest.service.LetteredService;

@RestController
@CrossOrigin("*")
public class LetteredController {

	@Autowired
	LetteredService letteredService;

	@Autowired
	LetteredDao letteredDao;

	@Column(name = "verification_time")
	private Long verificationTime;

	@GetMapping("/home2")
	public String home() {
		return "welcome";
	}

	@PostMapping("/saveLettered")
	public ResponseEntity<?> addlettered(@RequestBody LetteredDto letteredDto) throws ParseException {

		Map<String, Object> response = new HashMap<String, Object>();

		letteredService.addLettered(letteredDto);

		response.put("message", "success");
//			response.put("data", LetteredDto);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@GetMapping("getAllLettered")
	public List<LetteredDto> getAllLettered() throws JsonMappingException, JsonProcessingException {
		List<LetteredDto> letteredDtos = letteredService.getAllLettered();
		return letteredDtos;
	}

	@GetMapping("getOneLettered/{letteredId}")
	public LetteredDto getOneLettered(@PathVariable Long letteredId)
			throws JsonMappingException, JsonProcessingException {
		LetteredDto letteredDtos = letteredService.getOneLettered(letteredId);
		return letteredDtos;
	}

	@PutMapping("/updateLettered")
	public ResponseEntity<?> updateLettered(@RequestBody LetteredDto letteredDto) throws ParseException {

		Map<String, Object> response = new HashMap<String, Object>();

		letteredService.updateLettered(letteredDto);

		response.put("message", "success");
//			response.put("data", LetteredDto);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@DeleteMapping("/deleteLettered/{letteredId}")
	public ResponseEntity<String> deleteLettered(@PathVariable String letteredId) throws ParseException {

		if (this.letteredService.deleteLettered(Long.parseLong(letteredId))) {

			return ResponseEntity.status(HttpStatus.OK).body(" Deleted Successfully");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("RoutesId Not Found");
		}

	}
}
