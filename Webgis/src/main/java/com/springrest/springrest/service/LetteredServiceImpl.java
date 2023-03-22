package com.springrest.springrest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.simple.JSONObject;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.geojson.GeoJsonReader;
import org.locationtech.jts.io.geojson.GeoJsonWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springrest.springrest.dao.LetteredDao;
import com.springrest.springrest.dto.LetteredDto;
import com.springrest.springrest.entity.TblLetteredEntity;

@Service
public class LetteredServiceImpl implements LetteredService {

	@Autowired
	LetteredDao letteredDao;

	@Override
	public void addLettered(LetteredDto letteredDto) throws ParseException {

		/* set the data to TblLetteredEntity from LetteredDto */
		TblLetteredEntity tblLetteredEntity = new TblLetteredEntity();
		tblLetteredEntity.setDesignation(letteredDto.getDesignation());
		tblLetteredEntity.setFillColor(letteredDto.getFillColor());
		tblLetteredEntity.setLineColor(letteredDto.getLineColor());
		tblLetteredEntity.setLineWidth(letteredDto.getLineWidth());
		tblLetteredEntity.setCenter(letteredDto.getCenter());

		/* convert GeoJson to (Circle) geometry */
		GeoJsonReader geoJsonReader = new GeoJsonReader();
		Geometry geometry = geoJsonReader.read(letteredDto.getGeoJson().toJSONString());
		tblLetteredEntity.setPolygon((Polygon) geometry);

		/* add the tblLetteredEntity */
		letteredDao.save(tblLetteredEntity);

	}

	@Override
	public List<LetteredDto> getAllLettered() throws JsonMappingException, JsonProcessingException {

		List<TblLetteredEntity> list = letteredDao.findAll();
		List<LetteredDto> listDto = new ArrayList<>();

		for (TblLetteredEntity lettered : list) {
			LetteredDto letteredDto = new LetteredDto();

			/* set the data to LetteredDto from TblLetteredEntity */
			letteredDto.setLetteredId(lettered.getLetteredId());
			letteredDto.setDesignation(lettered.getDesignation());
			letteredDto.setFillColor(lettered.getFillColor());
			letteredDto.setLineColor(lettered.getLineColor());
			letteredDto.setLineWidth(lettered.getLineWidth());
			letteredDto.setCenter(lettered.getCenter());

			/* convert (Polygon) geometry to GeoJson */
			GeoJsonWriter geoJsonWriter = new GeoJsonWriter();
			ObjectMapper mapper = new ObjectMapper();
			letteredDto.setGeoJson(mapper.readValue(geoJsonWriter.write(lettered.getPolygon()), JSONObject.class));

			/* add the letteredDto */
			listDto.add(letteredDto);
		}
		return listDto;
	}

	@Override
	public LetteredDto getOneLettered(Long letteredId) throws JsonMappingException, JsonProcessingException {

		Optional<TblLetteredEntity> tblLetteredEntity = letteredDao.findById(letteredId);
		LetteredDto letteredDto = new LetteredDto();
		if (tblLetteredEntity.isPresent()) {
			/* set the data to PolygonDto from TblPolygonEntity */
			letteredDto.setLetteredId(tblLetteredEntity.get().getLetteredId());
			letteredDto.setDesignation(tblLetteredEntity.get().getDesignation().toString());
			letteredDto.setFillColor(tblLetteredEntity.get().getFillColor().toString());
			letteredDto.setLineColor(tblLetteredEntity.get().getLineColor().toString());
			letteredDto.setLineWidth(tblLetteredEntity.get().getLineWidth());
			letteredDto.setCenter(tblLetteredEntity.get().getCenter());

			/* convert (Polygon) geometry to GeoJson */
			GeoJsonWriter geoJsonWriter = new GeoJsonWriter();
			ObjectMapper mapper = new ObjectMapper();
			letteredDto.setGeoJson(
					mapper.readValue(geoJsonWriter.write(tblLetteredEntity.get().getPolygon()), JSONObject.class));
		}
		return letteredDto;
	}

	@Override
	public void updateLettered(LetteredDto letteredDto) throws ParseException {
		/* set the data to TblPolygonEntity from PolygonDto */
		TblLetteredEntity tblLetteredEntity = new TblLetteredEntity();
		tblLetteredEntity.setLetteredId(letteredDto.getLetteredId());
		tblLetteredEntity.setDesignation(letteredDto.getDesignation());
		tblLetteredEntity.setFillColor(letteredDto.getFillColor());
		tblLetteredEntity.setLineColor(letteredDto.getLineColor());
		tblLetteredEntity.setLineWidth(letteredDto.getLineWidth());
		tblLetteredEntity.setCenter(letteredDto.getCenter());

		/* convert GeoJson to (Polygon) geometry */
		GeoJsonReader geoJsonReader = new GeoJsonReader();
		Geometry geometry = geoJsonReader.read(letteredDto.getGeoJson().toJSONString());
		tblLetteredEntity.setPolygon((Polygon) geometry);

		/* add the tblPolygonEntity */
		letteredDao.save(tblLetteredEntity);
	}

	@Override
	public boolean deleteLettered(Long letteredId) {
		Optional<TblLetteredEntity> tblLetteredEntity = letteredDao.findById(letteredId);
		if (tblLetteredEntity.isPresent()) {
			letteredDao.delete(tblLetteredEntity.get());
			return true;
		}
		return false;

	}

}
