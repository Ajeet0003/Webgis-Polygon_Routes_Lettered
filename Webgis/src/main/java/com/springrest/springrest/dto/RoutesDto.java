package com.springrest.springrest.dto;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class RoutesDto {

	private Long routesId;

	private String designation;

	private JSONObject geoJson;

	private String fillColor;

	private String lineColor;

	private Integer lineWidth;

	private Integer numberOfLag;

	private Integer speed;

	public Long getRoutesId() {
		return routesId;
	}

	public void setRoutesId(Long routesId) {
		this.routesId = routesId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public JSONObject getGeoJson() {
		return geoJson;
	}

	public void setGeoJson(JSONObject geoJson) {
		this.geoJson = geoJson;
	}

	public String getFillColor() {
		return fillColor;
	}

	public void setFillColor(String fillColor) {
		this.fillColor = fillColor;
	}

	public String getLineColor() {
		return lineColor;
	}

	public void setLineColor(String lineColor) {
		this.lineColor = lineColor;
	}

	public Integer getLineWidth() {
		return lineWidth;
	}

	public void setLineWidth(Integer lineWidth) {
		this.lineWidth = lineWidth;
	}

	public Integer getNumberOfLag() {
		return numberOfLag;
	}

	public void setNumberOfLag(Integer numberOfLag) {
		this.numberOfLag = numberOfLag;
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

}
