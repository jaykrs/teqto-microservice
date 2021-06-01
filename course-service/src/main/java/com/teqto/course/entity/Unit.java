package com.teqto.course.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the unit database table.
 * 
 */
@Entity
@Table(name="unit")
@NamedQuery(name="Unit.findAll", query="SELECT u FROM Unit u")
public class Unit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private BigInteger courseId;

	@Temporal(TemporalType.DATE)
	private Date createdOn;

	private String introductoryVideo;

	private String metadata;

	private int orderCount;

	@Lob
	private String unitBrief;

	private int unitDuration;

	private String unitTitle;

	public Unit() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigInteger getCourseId() {
		return this.courseId;
	}

	public void setCourseId(BigInteger courseId) {
		this.courseId = courseId;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getIntroductoryVideo() {
		return this.introductoryVideo;
	}

	public void setIntroductoryVideo(String introductoryVideo) {
		this.introductoryVideo = introductoryVideo;
	}

	public String getMetadata() {
		return this.metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	public int getOrderCount() {
		return this.orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public String getUnitBrief() {
		return this.unitBrief;
	}

	public void setUnitBrief(String unitBrief) {
		this.unitBrief = unitBrief;
	}

	public int getUnitDuration() {
		return this.unitDuration;
	}

	public void setUnitDuration(int unitDuration) {
		this.unitDuration = unitDuration;
	}

	public String getUnitTitle() {
		return this.unitTitle;
	}

	public void setUnitTitle(String unitTitle) {
		this.unitTitle = unitTitle;
	}

}