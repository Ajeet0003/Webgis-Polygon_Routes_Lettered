package com.springrest.springrest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;
import com.sun.istack.NotNull;

@Entity
public class TblLetteredEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long letteredId;

	@NotNull
	@Column(name = "designation")
	private String designation;

	@Column(name = "polygon", columnDefinition = "geometry")
	private Polygon polygon;

	@Column(name = "center")
	private Point center;

	@Column(name = "fillColor")
	private String fillColor;

	@Column(name = "lineColor")
	private String lineColor;

	@Column(name = "lineWidth")
	private Integer lineWidth;

	@Column(name = "innerRadius")
	private Integer innerRadius;

	@Column(name = "outerRadius")
	private Integer outerRadius;

	@Column(name = "startArc")
	private Integer startArc;

	@Column(name = "endArc")
	private Integer endArc;

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
