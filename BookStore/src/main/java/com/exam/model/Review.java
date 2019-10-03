package com.exam.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "reviewerName", "content", "rating", "publishedDate" })
public class Review {

	@JsonProperty("reviewerName")
	private String reviewerName;

	@JsonProperty("content")
	private String content;

	@JsonProperty("rating")
	private Double rating;

	@JsonProperty("publishedDate")
	private Date publishedDate;

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
