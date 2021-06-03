package com.teqto.course.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the chapter database table.
 * 
 */
@Entity
@Table(name="chapter")
@NamedQuery(name="Chapter.findAll", query="SELECT c FROM Chapter c")
public class Chapter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private int id;

	@Lob
	@Column(name = "CHAPTER_BRIEF")
	private String chapterBrief;

	@Lob
	@Column(name = "CHAPTER_CONTENT")
	private String chapterContent;

	@Column(name = "CHAPTER_DURATION")
	private int chapterDuration;

	@Column(name = "CHAPTER_ORDER")
	private int chapterOrder;

	@Column(name = "CHAPTER_RESOURCE")
	private String chapterResource;

	@Column(name = "CHAPTER_TITLE")
	private String chapterTitle;

	@Column(name = "CHAPTER_TYPE")
	private String chapterType;

	@Column(name = "METADATA")
	private String metadata;
	
	@Column(name = "COURSE_ID")
	private int courseId;

	@JsonIgnore
	@ManyToOne(targetEntity = Unit.class)
	@JoinColumn(name = "UNIT_ID", nullable = false)
	private Unit unit;

	public Chapter() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChapterBrief() {
		return this.chapterBrief;
	}

	public void setChapterBrief(String chapterBrief) {
		this.chapterBrief = chapterBrief;
	}

	public String getChapterContent() {
		return this.chapterContent;
	}

	public void setChapterContent(String chapterContent) {
		this.chapterContent = chapterContent;
	}

	public int getChapterDuration() {
		return this.chapterDuration;
	}

	public void setChapterDuration(int chapterDuration) {
		this.chapterDuration = chapterDuration;
	}

	public int getChapterOrder() {
		return this.chapterOrder;
	}

	public void setChapterOrder(int chapterOrder) {
		this.chapterOrder = chapterOrder;
	}

	public String getChapterResource() {
		return this.chapterResource;
	}

	public void setChapterResource(String chapterResource) {
		this.chapterResource = chapterResource;
	}

	public String getChapterTitle() {
		return this.chapterTitle;
	}

	public void setChapterTitle(String chapterTitle) {
		this.chapterTitle = chapterTitle;
	}

	public String getChapterType() {
		return this.chapterType;
	}

	public void setChapterType(String chapterType) {
		this.chapterType = chapterType;
	}

	public String getMetadata() {
		return this.metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	/**
	 * @return the unit
	 */
	public Unit getUnit() {
		return unit;
	}

	/**
	 * @param unit the unit to set
	 */
	public void setUnit(Unit unit) {
		this.unit = unit;
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

}