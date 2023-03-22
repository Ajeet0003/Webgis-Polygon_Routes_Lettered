package com.springrest.springrest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.simple.JSONObject;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.geojson.GeoJsonReader;
import org.locationtech.jts.io.geojson.GeoJsonWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springrest.springrest.dao.RoutesDao;
import com.springrest.springrest.dto.RoutesDto;
import com.springrest.springrest.entity.TblRoutesEntity;

@Service
public class RoutesServiceImpl implements RoutesService {

	@Autowired
	RoutesDao routesDao;

	@Override
	public void addAndUpdateRoutes(RoutesDto routesDto) throws ParseException {

		TblRoutesEntity tblRoutesEntity = new TblRoutesEntity();
		/* Checking Designation already exist in DB or not */
		Optional<TblRoutesEntity> tblRoutesEntityOptional = routesDao.findByDesignation(routesDto.getDesignation());
		if (tblRoutesEntityOptional.isPresent())
			tblRoutesEntity = tblRoutesEntityOptional.get();

		/* set the data to TblRoutesEntity from RoutesDto */
		tblRoutesEntity.setDesignation(routesDto.getDesignation());
		tblRoutesEntity.setLineColor(routesDto.getLineColor());
		tblRoutesEntity.setLineWidth(routesDto.getLineWidth());

		/* convert GeoJson to (LineString) geometry */
		GeoJsonReader geoJsonReader = new GeoJsonReader();
		Geometry geometry = geoJsonReader.read(routesDto.getGeoJson().toJSONString());
		tblRoutesEntity.setLineString((LineString) geometry);

		/* add the tblPolygonEntity */
		routesDao.save(tblRoutesEntity);

	}

	@Override
	public List<RoutesDto> getAllRoutes() throws JsonMappingException, JsonProcessingException {

		List<TblRoutesEntity> tblRoutesEntityList = routesDao.findAll();
		List<RoutesDto> routesDtoList = new ArrayList<>();

		for (TblRoutesEntity tblRoutesEntity : tblRoutesEntityList) {
			RoutesDto routesDto = new RoutesDto();

			/* set the data to RoutesDto from TblRoutesEntity */
			routesDto.setRoutesId(tblRoutesEntity.getRoutesId());
			routesDto.setDesignation(tblRoutesEntity.getDesignation());
			routesDto.setLineColor(tblRoutesEntity.getLineColor());
			routesDto.setLineWidth(tblRoutesEntity.getLineWidth());

			/* convert (LineString) geometry to GeoJson */
			GeoJsonWriter geoJsonWriter = new GeoJsonWriter();
			ObjectMapper mapper = new ObjectMapper();
			routesDto.setGeoJson(
					mapper.readValue(geoJsonWriter.write(tblRoutesEntity.getLineString()), JSONObject.class));
			/* add the RoutesDto */
			routesDtoList.add(routesDto);
		}
		return routesDtoList;
	}

	@Override
	public RoutesDto getOneRoutes(Long routesId) throws JsonMappingException, JsonProcessingException {

		Optional<TblRoutesEntity> tblRoutesEntityOptional = routesDao.findById(routesId);
		RoutesDto routesDto = new RoutesDto();
		if (tblRoutesEntityOptional.isPresent()) {
			/* set the data to RoutesDto from TblRoutesEntity */
			routesDto.setRoutesId(tblRoutesEntityOptional.get().getRoutesId());
			routesDto.setDesignation(tblRoutesEntityOptional.get().getDesignation().toString());
			routesDto.setLineColor(tblRoutesEntityOptional.get().getLineColor().toString());
			routesDto.setLineWidth(tblRoutesEntityOptional.get().getLineWidth());

			/* convert (Polygon) geometry to GeoJson */
			GeoJsonWriter geoJsonWriter = new GeoJsonWriter();
			ObjectMapper mapper = new ObjectMapper();
			routesDto.setGeoJson(mapper.readValue(geoJsonWriter.write(tblRoutesEntityOptional.get().getLineString()),
					JSONObject.class));
		}
		return routesDto;
	}

	@Override
	public RoutesDto getRoutesByDesignation(String designation) throws JsonMappingException, JsonProcessingException {

		Optional<TblRoutesEntity> tblRoutesEntityOptional = routesDao.findByDesignation(designation);
		RoutesDto routesDto = new RoutesDto();
		if (tblRoutesEntityOptional.isPresent()) {
			/* set the data to RoutesDto from TblRoutesEntity */
			routesDto.setRoutesId(tblRoutesEntityOptional.get().getRoutesId());
			routesDto.setDesignation(tblRoutesEntityOptional.get().getDesignation().toString());
			routesDto.setLineColor(tblRoutesEntityOptional.get().getLineColor().toString());
			routesDto.setLineWidth(tblRoutesEntityOptional.get().getLineWidth());

			/* convert (Polygon) geometry to GeoJson */
			GeoJsonWriter geoJsonWriter = new GeoJsonWriter();
			ObjectMapper mapper = new ObjectMapper();
			routesDto.setGeoJson(mapper.readValue(geoJsonWriter.write(tblRoutesEntityOptional.get().getLineString()),
					JSONObject.class));
		}
		return routesDto;
	}

	@Override
	public void updateRoutes(RoutesDto routesDto) throws ParseException {
		/* set the data to TblRoutesEntity from RoutesDto */
		TblRoutesEntity tblRoutesEntity = new TblRoutesEntity();
		tblRoutesEntity.setRoutesId(routesDto.getRoutesId());
		tblRoutesEntity.setDesignation(routesDto.getDesignation());
		tblRoutesEntity.setLineColor(routesDto.getLineColor());
		tblRoutesEntity.setLineWidth(routesDto.getLineWidth());

		/* convert GeoJson to (LineString) geometry */
		GeoJsonReader geoJsonReader = new GeoJsonReader();
		Geometry geometry = geoJsonReader.read(routesDto.getGeoJson().toJSONString());
		tblRoutesEntity.setLineString((LineString) geometry);

		/* add the TblRoutesEntity */
		routesDao.save(tblRoutesEntity);
	}

	@Override
	public void deleteRoutes(RoutesDto routesDto) throws Exception {
		Optional<TblRoutesEntity> tblRoutesEntityOptional = routesDao.findByDesignation(routesDto.getDesignation());
		if (tblRoutesEntityOptional.isPresent()) {
			routesDao.delete(tblRoutesEntityOptional.get());

		} else {
			throw new Exception("Routes not present");

		}

	}
}