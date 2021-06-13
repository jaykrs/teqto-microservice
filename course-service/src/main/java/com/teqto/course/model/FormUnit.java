package com.teqto.course.model;

import java.io.Serializable;


/**
 * The persistent class for the course database table.
 * 
 */
public class FormUnit implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	private int courseId;
	
	private String introductoryVideo;

	private String metadata;

	private int orderCount;

	private String unitBrief;

	private int unitDuration;

	private String unitTitle;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the courseId
	 */
	public int getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	/**
	 * @return the introductoryVideo
	 */
	public String getIntroductoryVideo() {
		return introductoryVideo;
	}

	/**
	 * @param introductoryVideo the introductoryVideo to set
	 */
	public void setIntroductoryVideo(String introductoryVideo) {
		this.introductoryVideo = introductoryVideo;
	}

	/**
	 * @return the metadata
	 */
	public String getMetadata() {
		return metadata;
	}

	/**
	 * @param metadata the metadata to set
	 */
	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	/**
	 * @return the orderCount
	 */
	public int getOrderCount() {
		return orderCount;
	}

	/**
	 * @param orderCount the orderCount to set
	 */
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	/**
	 * @return the unitBrief
	 */
	public String getUnitBrief() {
		return unitBrief;
	}

	/**
	 * @param unitBrief the unitBrief to set
	 */
	public void setUnitBrief(String unitBrief) {
		this.unitBrief = unitBrief;
	}

	/**
	 * @return the unitDuration
	 */
	public int getUnitDuration() {
		return unitDuration;
	}

	/**
	 * @param unitDuration the unitDuration to set
	 */
	public void setUnitDuration(int unitDuration) {
		this.unitDuration = unitDuration;
	}

	/**
	 * @return the unitTitle
	 */
	public String getUnitTitle() {
		return unitTitle;
	}

	/**
	 * @param unitTitle the unitTitle to set
	 */
	public void setUnitTitle(String unitTitle) {
		this.unitTitle = unitTitle;
	}

	
}