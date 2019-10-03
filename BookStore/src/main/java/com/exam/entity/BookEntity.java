package com.exam.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "Book")
public class BookEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bookId")
	private Integer bookId;

	@Column(name = "title")
	private String title;

	@Column(name = "author")
	private String author;

	@Temporal(value = TemporalType.DATE)
	@Column(name = "publishedDate")
	private Date publishedDate;

	@Column(name = "isbn")
	private String isbn;

	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "bookEntity",fetch = FetchType.EAGER)
	@OrderBy("reviewId")
	private List<ReviewEntity> reviewEntities = new ArrayList<>();

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public List<ReviewEntity> getReviewEntities() {
		return reviewEntities;
	}

	public void setReviewEntities(List<ReviewEntity> reviewEntities) {
		this.reviewEntities = reviewEntities;
	}

}