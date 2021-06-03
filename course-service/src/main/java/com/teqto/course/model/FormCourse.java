package com.teqto.course.model;

import java.io.Serializable;


/**
 * The persistent class for the course database table.
 * 
 */
public class FormCourse implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String name;
	
	private String title;
	
	private String description;
	
	private String requirement;
	
	private int courseBaseLanguage;
	
	private int courseSecondaryLanguage;
	
	private int courseCatagory;

	private int courseCurrency;
	
	private int courseDiscountPc;
	
	private int courseFee;

	private String courseIntroPath;

	private String courseLogoPathBig;

	private String courseLogoPathSmall;

	private String courseModerator;	

	private int courseType;

	private String keyword;
	
	private int audiance;	
	
	private String metakeyworddesc;	

	private int publishStatus;

	private String shareUrl;


	public FormCourse() {
	}

	public int getCourseBaseLanguage() {
		return this.courseBaseLanguage;
	}

	public void setCourseBaseLanguage(int courseBaseLanguage) {
		this.courseBaseLanguage = courseBaseLanguage;
	}

	public int getCourseCatagory() {
		return this.courseCatagory;
	}

	public void setCourseCatagory(int courseCatagory) {
		this.courseCatagory = courseCatagory;
	}

	public int getCourseCurrency() {
		return this.courseCurrency;
	}

	public void setCourseCurrency(int courseCurrency) {
		this.courseCurrency = courseCurrency;
	}

	public int getCourseDiscountPc() {
		return this.courseDiscountPc;
	}

	public void setCourseDiscountPc(int courseDiscountPc) {
		this.courseDiscountPc = courseDiscountPc;
	}

	public int getCourseFee() {
		return this.courseFee;
	}

	public void setCourseFee(int courseFee) {
		this.courseFee = courseFee;
	}

	public String getCourseIntroPath() {
		return this.courseIntroPath;
	}

	public void setCourseIntroPath(String courseIntroPath) {
		this.courseIntroPath = courseIntroPath;
	}

	public String getCourseLogoPathBig() {
		return this.courseLogoPathBig;
	}

	public void setCourseLogoPathBig(String courseLogoPathBig) {
		this.courseLogoPathBig = courseLogoPathBig;
	}

	public String getCourseLogoPathSmall() {
		return this.courseLogoPathSmall;
	}

	public void setCourseLogoPathSmall(String courseLogoPathSmall) {
		this.courseLogoPathSmall = courseLogoPathSmall;
	}

	public String getCourseModerator() {
		return this.courseModerator;
	}

	public void setCourseModerator(String courseModerator) {
		this.courseModerator = courseModerator;
	}

	public int getCourseSecondaryLanguage() {
		return this.courseSecondaryLanguage;
	}

	public void setCourseSecondaryLanguage(int courseSecondaryLanguage) {
		this.courseSecondaryLanguage = courseSecondaryLanguage;
	}

	public int getCourseType() {
		return this.courseType;
	}

	public void setCourseType(int courseType) {
		this.courseType = courseType;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getPublishStatus() {
		return this.publishStatus;
	}

	public void setPublishStatus(int publishStatus) {
		this.publishStatus = publishStatus;
	}

	public String getShareUrl() {
		return this.shareUrl;
	}

	public void setShareUrl(String shareUrl) {
		this.shareUrl = shareUrl;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the metakeyworddesc
	 */
	public String getMetakeyworddesc() {
		return metakeyworddesc;
	}

	/**
	 * @param metakeyworddesc the metakeyworddesc to set
	 */
	public void setMetakeyworddesc(String metakeyworddesc) {
		this.metakeyworddesc = metakeyworddesc;
	}

	/**
	 * @return the requirement
	 */
	public String getRequirement() {
		return requirement;
	}

	/**
	 * @param requirement the requirement to set
	 */
	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	/**
	 * @return the audiance
	 */
	public int getAudiance() {
		return audiance;
	}

	/**
	 * @param audiance the audiance to set
	 */
	public void setAudiance(int audiance) {
		this.audiance = audiance;
	}

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

}