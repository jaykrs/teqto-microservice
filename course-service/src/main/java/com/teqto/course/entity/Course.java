package com.teqto.course.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the course database table.
 * 
 */
@Entity
@NamedQuery(name="Course.findAll", query="SELECT c FROM Course c")
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="ARTICLE_ID")
	private int articleId;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "course")
	@OrderBy("orderCount ASC")
	private Set<Unit> units = new HashSet<Unit>();

	@Column(name="COURSE_BASE_LANGUAGE")
	private int courseBaseLanguage;

	@Column(name="COURSE_CATAGORY")
	private int courseCatagory;

	@Column(name="COURSE_CURRENCY")
	private int courseCurrency;

	@Column(name="COURSE_DISCOUNT_PC")
	private int courseDiscountPc;

	@Column(name="COURSE_FEE")
	private int courseFee;

	@Column(name="COURSE_INTRO_PATH")
	private String courseIntroPath;

	@Column(name="COURSE_LOGO_PATH_BIG")
	private String courseLogoPathBig;

	@Column(name="COURSE_LOGO_PATH_SMALL")
	private String courseLogoPathSmall;

	@Column(name="COURSE_MODERATOR")
	private int courseModerator;

	@Column(name="COURSE_SECONDARY_LANGUAGE")
	private int courseSecondaryLanguage;

	@Column(name="COURSE_TYPE")
	private int courseType;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE")
	private Date createdDate;

	@Lob
	private String description;

	private String keyword;
	
	@Column(name="AUDIANCE")
	private int audiance;
	
	private String requirement;
	
	private String metakeyworddesc;

	@Column(name="LIKE_COUNT")
	private int likeCount;

	@Column(name="LIKE_USER_ID")
	private String likeUserId;

	@Column(name="MODIFIED_BY")
	private int modifiedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="MODIFIED_DATE")
	private Date modifiedDate;

	private String name;

	@Temporal(TemporalType.DATE)
	@Column(name="PUBLISH_DATE")
	private Date publishDate;

	@Column(name="PUBLISH_STATUS")
	private int publishStatus;

	@Column(name="SHARE_URL")
	private String shareUrl;

	@Column(name="SUBSCRIPTION_COUNT")
	private int subscriptionCount;

	private String title;
	
	@Column(name="COURSE_MODERATOR_NAME")
	private String courseModeratorName;

	public Course() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getArticleId() {
		return this.articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
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

	public int getCourseModerator() {
		return this.courseModerator;
	}

	public void setCourseModerator(int courseModerator) {
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

	public int getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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

	public int getLikeCount() {
		return this.likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public String getLikeUserId() {
		return this.likeUserId;
	}

	public void setLikeUserId(String likeUserId) {
		this.likeUserId = likeUserId;
	}

	public int getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
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

	public int getSubscriptionCount() {
		return this.subscriptionCount;
	}

	public void setSubscriptionCount(int subscriptionCount) {
		this.subscriptionCount = subscriptionCount;
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
	 * @return the courseModeratorName
	 */
	public String getCourseModeratorName() {
		return courseModeratorName;
	}

	/**
	 * @param courseModeratorName the courseModeratorName to set
	 */
	public void setCourseModeratorName(String courseModeratorName) {
		this.courseModeratorName = courseModeratorName;
	}

	/**
	 * @return the units
	 */
	public Set<Unit> getUnits() {
		return units;
	}

	/**
	 * @param units the units to set
	 */
	public void setUnits(Set<Unit> units) {
		this.units = units;
	}

}