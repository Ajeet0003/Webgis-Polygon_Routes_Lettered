package com.springrest.springrest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.locationtech.jts.geom.LineString;
import com.sun.istack.NotNull;

@Entity
public class TblRoutesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long routesId;

	@NotNull
	@Column(nullable = false)
	private String designation;

	@Column(name = "lineString", columnDefinition = "geometry")
	private LineString lineString;

	@Column(name = "line_color")
	private String lineColor;

	@Column(name = "line_width")
	private Integer lineWidth;

	public Long getRoutesId() {
		return routesId;
	}

	public void setRoutesId(Long routesId) {
		this.routesId = routesId;
	}

	public LineString getLineString() {
		return lineString;
	}

	public void setLineString(LineString lineString) {
		this.lineString = lineString;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
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

}
