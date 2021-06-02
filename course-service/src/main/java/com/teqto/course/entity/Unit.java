package com.teqto.course.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the unit database table.
 * 
 */
@Entity
@Table(name="UNIT")
@NamedQuery(name="Unit.findAll", query="SELECT u FROM Unit u")
public class Unit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private int id;

	@JsonIgnore
	@ManyToOne(targetEntity = Course.class)
	@JoinColumn(name = "COURSE_ID", nullable = false)
	private Course course;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "unit")
	@OrderBy("chapterOrder ASC")
	private Set<Chapter> chapters = new HashSet<Chapter>();
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_ON")
	private Date createdOn;

	@Column(name = "INTRODUCTORY_VIDEO")
	private String introductoryVideo;

	@Column(name = "METADATA")
	private String metadata;

	@Column(name = "ORDER_COUNT")
	private int orderCount;

	@Lob
	@Column(name = "UNIT_BRIEF")
	private String unitBrief;

	@Column(name = "UNIT_DURATION")
	private int unitDuration;

	@Column(name = "UNIT_TITLE")
	private String unitTitle;

	public Unit() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

	/**
	 * @return the chapters
	 */
	public Set<Chapter> getChapters() {
		return chapters;
	}

	/**
	 * @param chapters the chapters to set
	 */
	public void setChapters(Set<Chapter> chapters) {
		this.chapters = chapters;
	}

}