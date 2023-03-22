package com.springrest.springrest.dto;

import org.json.simple.JSONObject;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Component;

@Component
public class LetteredDto {

	private Long letteredId;

	private String designation;

	private JSONObject geoJson;

	private Point center;

	private String fillColor;

	private String lineColor;

	private Integer lineWidth;

	private Integer innerRadius;

	private Integer outerRadius;

	private Integer startArc;

	private Integer endArc;

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

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
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

	public Long getLetteredId() {
		return letteredId;
	}

	public void setLetteredId(Long letteredId) {
		this.letteredId = letteredId;
	}

	public Integer getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(Integer innerRadius) {
		this.innerRadius = innerRadius;
	}

	public Integer getOuterRadius() {
		return outerRadius;
	}

	public void setOuterRadius(Integer outerRadius) {
		this.outerRadius = outerRadius;
	}

	public Integer getStartArc() {
		return startArc;
	}

	public void setStartArc(Integer startArc) {
		this.startArc = startArc;
	}

	public Integer getEndArc() {
		return endArc;
	}

	public void setEndArc(Integer endArc) {
		this.endArc = endArc;
	}

}