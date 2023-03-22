package com.springrest.springrest.dto;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class PolygonDto {

		private Long polyId;

		private String designation;

		private JSONObject geoJson;

		private String fillColor;

		private String lineColor;

		private Integer lineWidth;

		private Double transparency;

		public Long getPolyId() {
			return polyId;
		}

		public void setPolyId(Long polyId) {
			this.polyId = polyId;
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

		public Double getTransparency() {
			return transparency;
		}

		public void setTransparency(Double transparency) {
			this.transparency = transparency;
		}

		

	}

