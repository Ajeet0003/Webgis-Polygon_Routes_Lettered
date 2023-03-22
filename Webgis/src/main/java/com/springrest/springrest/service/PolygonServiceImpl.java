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
import com.springrest.springrest.dao.PolygonDao;
import com.springrest.springrest.dto.PolygonDto;
import com.springrest.springrest.entity.TblPolygon;

@Service
public class PolygonServiceImpl implements PolygonService {

	@Autowired
	PolygonDao polygonDao;

	@Override
	public void addAndUpdatePolygon(PolygonDto polygonDto) throws ParseException {

		/* set the data to TblPolygonEntity from PolygonDto */
		TblPolygon tblPolygon = new TblPolygon();

		Optional<TblPolygon> tblPolygonOptional = polygonDao.findByDesignation(polygonDto.getDesignation());
		if (tblPolygonOptional.isPresent())
			tblPolygon = tblPolygonOptional.get();

		tblPolygon.setDesignation(polygonDto.getDesignation());
		tblPolygon.setFillColor(polygonDto.getFillColor());
		tblPolygon.setLineColor(polygonDto.getLineColor());
		tblPolygon.setLineWidth(polygonDto.getLineWidth());
		tblPolygon.setTransparency(polygonDto.getTransparency());

		/* convert GeoJson to (Polygon) geometry */
		GeoJsonReader geoJsonReader = new GeoJsonReader();
		Geometry geometry = geoJsonReader.read(polygonDto.getGeoJson().toJSONString());
		tblPolygon.setPolygon((Polygon) geometry);

		/* add the tblPolygonEntity */
		polygonDao.save(tblPolygon);

	}

	@Override
	public List<PolygonDto> getAllPolygon() throws JsonMappingException, JsonProcessingException {

		List<TblPolygon> list = polygonDao.findAll();
		List<PolygonDto> listDto = new ArrayList<>();

		for (TblPolygon polygon : list) {
			PolygonDto polygonDto = new PolygonDto();

			/* set the data to PolygonDto from TblPolygonEntity */
			polygonDto.setPolyId(polygon.getPolyId());
			polygonDto.setDesignation(polygon.getDesignation());
			polygonDto.setFillColor(polygon.getFillColor());
			polygonDto.setLineColor(polygon.getLineColor());
			polygonDto.setLineWidth(polygon.getLineWidth());
			polygonDto.setTransparency(polygon.getTransparency());

			/* convert (Polygon) geometry to GeoJson */
			GeoJsonWriter geoJsonWriter = new GeoJsonWriter();
			ObjectMapper mapper = new ObjectMapper();
			polygonDto.setGeoJson(mapper.readValue(geoJsonWriter.write(polygon.getPolygon()), JSONObject.class));

			/* add the polygonDto */
			listDto.add(polygonDto);
		}
		return listDto;
	}

	@Override
	public PolygonDto getOnePolygon(Long polygoneId) throws JsonMappingException, JsonProcessingException {

		Optional<TblPolygon> tblPolygonEntity = polygonDao.findById(polygoneId);
		PolygonDto polygonDto = new PolygonDto();
		if (tblPolygonEntity.isPresent()) {
			/* set the data to PolygonDto from TblPolygonEntity */
			polygonDto.setPolyId(tblPolygonEntity.get().getPolyId());
			polygonDto.setDesignation(tblPolygonEntity.get().getDesignation().toString());
			polygonDto.setFillColor(tblPolygonEntity.get().getFillColor().toString());
			polygonDto.setLineColor(tblPolygonEntity.get().getLineColor().toString());
			polygonDto.setLineWidth(tblPolygonEntity.get().getLineWidth());
			polygonDto.setTransparency(tblPolygonEntity.get().getTransparency());

			/* convert (Polygon) geometry to GeoJson */
			GeoJsonWriter geoJsonWriter = new GeoJsonWriter();
			ObjectMapper mapper = new ObjectMapper();
			polygonDto.setGeoJson(
					mapper.readValue(geoJsonWriter.write(tblPolygonEntity.get().getPolygon()), JSONObject.class));
		}
		return polygonDto;
	}

	@Override
	public PolygonDto getPolygonByDesignation(String designation) throws JsonMappingException, JsonProcessingException {

		Optional<TblPolygon> tblPolygonEntity = polygonDao.findByDesignation(designation);
		PolygonDto polygonDto = new PolygonDto();
		if (tblPolygonEntity.isPresent()) {
			/* set the data to PolygonDto from TblPolygonEntity */
			polygonDto.setPolyId(tblPolygonEntity.get().getPolyId());
			polygonDto.setDesignation(tblPolygonEntity.get().getDesignation().toString());
			polygonDto.setFillColor(tblPolygonEntity.get().getFillColor().toString());
			polygonDto.setLineColor(tblPolygonEntity.get().getLineColor().toString());
			polygonDto.setLineWidth(tblPolygonEntity.get().getLineWidth());
			polygonDto.setTransparency(tblPolygonEntity.get().getTransparency());

			/* convert (Polygon) geometry to GeoJson */
			GeoJsonWriter geoJsonWriter = new GeoJsonWriter();
			ObjectMapper mapper = new ObjectMapper();
			polygonDto.setGeoJson(
					mapper.readValue(geoJsonWriter.write(tblPolygonEntity.get().getPolygon()), JSONObject.class));
		}
		return polygonDto;
	}

	@Override
	public void updatePolygon(PolygonDto polygonDto) throws ParseException {
		/* set the data to TblPolygonEntity from PolygonDto */
		TblPolygon tblPolygonEntity = new TblPolygon();
		tblPolygonEntity.setPolyId(polygonDto.getPolyId());
		tblPolygonEntity.setDesignation(polygonDto.getDesignation());
		tblPolygonEntity.setFillColor(polygonDto.getFillColor());
		tblPolygonEntity.setLineColor(polygonDto.getLineColor());
		tblPolygonEntity.setLineWidth(polygonDto.getLineWidth());
		tblPolygonEntity.setTransparency(polygonDto.getTransparency());

		/* convert GeoJson to (Polygon) geometry */
		GeoJsonReader geoJsonReader = new GeoJsonReader();
		Geometry geometry = geoJsonReader.read(polygonDto.getGeoJson().toJSONString());
		tblPolygonEntity.setPolygon((Polygon) geometry);

		/* add the tblPolygonEntity */
		polygonDao.save(tblPolygonEntity);
	}

	@Override
	public void deletePolygon(PolygonDto polygonDto) throws Exception {
		Optional<TblPolygon> tblPolygonEntityOptional = polygonDao.findByDesignation(polygonDto.getDesignation());

		if (tblPolygonEntityOptional.isPresent()) {
			polygonDao.delete(tblPolygonEntityOptional.get());
		} else {
			throw new Exception("polygon not present");
		}
	}
}
