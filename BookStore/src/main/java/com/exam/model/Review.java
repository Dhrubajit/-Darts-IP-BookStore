package com.exam.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "reviewerName", "content", "rating", "publishedDate" })
@Entity
@Table(name = "Review")
public class Review {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="reviewId")
	private Integer reviewId;

	@JsonProperty("reviewerName")
	@Column(name="reviewerName")
	private String reviewerName;
	
	@JsonProperty("content")
	@Column(name="content")
	private String content;
	
	@JsonProperty("rating")
	@Column(name="rating")
	private Double rating;
	
	@JsonProperty("publishedDate")
	@Temporal(value=TemporalType.DATE)
	@Column(name="publishedDate")
	private Date publishedDate;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "fk_bookId")
	private Book book;
	
	

	@JsonProperty("reviewerName")
	public String getReviewerName() {
		return reviewerName;
	}

	@JsonProperty("reviewerName")
	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}

	public Review withReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
		return this;
	}

	@JsonProperty("content")
	public String getContent() {
		return content;
	}

	@JsonProperty("content")
	public void setContent(String content) {
		this.content = content;
	}

	public Review withContent(String content) {
		this.content = content;
		return this;
	}

	@JsonProperty("rating")
	public Double getRating() {
		return rating;
	}

	@JsonProperty("rating")
	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Review withRating(Double rating) {
		this.rating = rating;
		return this;
	}

	@JsonProperty("publishedDate")
	public Date getPublishedDate() {
		return publishedDate;
	}

	@JsonProperty("publishedDate")
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public Review withPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
		return this;
	}

}
