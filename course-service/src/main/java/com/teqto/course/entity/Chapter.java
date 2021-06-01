package com.teqto.course.entity;

import java.io.Serializable;
import javax.persistence.*;


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
	private int id;

	@Lob
	private String chapterBrief;

	@Lob
	private String chapterContent;

	private int chapterDuration;

	private int chapterOrder;

	private String chapterResource;

	private String chapterTitle;

	private String chapterType;

	private String metadata;

	private int unitId;

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

	public int getUnitId() {
		return this.unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

}