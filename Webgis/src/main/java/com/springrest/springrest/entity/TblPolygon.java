package com.springrest.springrest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.locationtech.jts.geom.Polygon;
import com.sun.istack.NotNull;

@Entity
public class TblPolygon {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long polyId;

	@NotNull
	@Column(nullable = false)
	private String designation;

	@Column(name = "polygon", columnDefinition = "geometry")
	private Polygon polygon;

	@Column(name = "fill_color")
	private String fillColor;

	@Column(name = "line_color")
	private String lineColor;

	@Column(name = "line_width")
	private Integer lineWidth;

	@Column(name = "transparency")
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

	public Polygon getPolygon() {
		return polygon;
	}

	public void setPolygon(Polygon polygon) {
		this.polygon = polygon;
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
