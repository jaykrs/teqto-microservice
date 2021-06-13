package com.teqto.course.model;

public class FormChapter {

	private int id;

	private String chapterBrief;

	private String chapterContent;

	private int chapterDuration;

	private int chapterOrder;

	private String chapterResource;

	private String chapterTitle;

	private String chapterType;

	private String metadata;

	private int unitId;
	
	private int courseId;

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
	 * @return the chapterBrief
	 */
	public String getChapterBrief() {
		return chapterBrief;
	}

	/**
	 * @param chapterBrief the chapterBrief to set
	 */
	public void setChapterBrief(String chapterBrief) {
		this.chapterBrief = chapterBrief;
	}

	/**
	 * @return the chapterDuration
	 */
	public int getChapterDuration() {
		return chapterDuration;
	}

	/**
	 * @param chapterDuration the chapterDuration to set
	 */
	public void setChapterDuration(int chapterDuration) {
		this.chapterDuration = chapterDuration;
	}

	/**
	 * @return the chapterOrder
	 */
	public int getChapterOrder() {
		return chapterOrder;
	}

	/**
	 * @param chapterOrder the chapterOrder to set
	 */
	public void setChapterOrder(int chapterOrder) {
		this.chapterOrder = chapterOrder;
	}

	/**
	 * @return the chapterResource
	 */
	public String getChapterResource() {
		return chapterResource;
	}

	/**
	 * @param chapterResource the chapterResource to set
	 */
	public void setChapterResource(String chapterResource) {
		this.chapterResource = chapterResource;
	}

	/**
	 * @return the chapterTitle
	 */
	public String getChapterTitle() {
		return chapterTitle;
	}

	/**
	 * @param chapterTitle the chapterTitle to set
	 */
	public void setChapterTitle(String chapterTitle) {
		this.chapterTitle = chapterTitle;
	}

	/**
	 * @return the chapterType
	 */
	public String getChapterType() {
		return chapterType;
	}

	/**
	 * @param chapterType the chapterType to set
	 */
	public void setChapterType(String chapterType) {
		this.chapterType = chapterType;
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
	 * @return the unitId
	 */
	public int getUnitId() {
		return unitId;
	}

	/**
	 * @param unitId the unitId to set
	 */
	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public String getChapterContent() {
		return chapterContent;
	}

	public void setChapterContent(String chapterContent) {
		this.chapterContent = chapterContent;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
}
