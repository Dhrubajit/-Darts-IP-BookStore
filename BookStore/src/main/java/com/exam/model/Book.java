package com.exam.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "title", "author", "publishedDate", "isbn", "reviews" })
public class Book {

	@JsonProperty("title")
	private String title;

	@JsonProperty("author")
	private String author;

	@JsonProperty("publishedDate")
	private Date publishedDate;

	@JsonProperty("isbn")
	private String isbn;

	@JsonProperty("reviews")
	private List<Review> reviews = new ArrayList<>();


	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	@JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
	}

	public Book withTitle(String title) {
		this.title = title;
		return this;
	}

	@JsonProperty("author")
	public String getAuthor() {
		return author;
	}

	@JsonProperty("author")
	public void setAuthor(String author) {
		this.author = author;
	}

	public Book withAuthor(String author) {
		this.author = author;
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

	public Book withPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
		return this;
	}

	@JsonProperty("isbn")
	public String getIsbn() {
		return isbn;
	}

	@JsonProperty("isbn")
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Book withIsbn(String isbn) {
		this.isbn = isbn;
		return this;
	}

	@JsonProperty("reviews")
	public List<Review> getReviews() {
		return reviews;
	}

	@JsonProperty("reviews")
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Book withReviews(List<Review> reviews) {
		this.reviews = reviews;
		return this;
	}

}