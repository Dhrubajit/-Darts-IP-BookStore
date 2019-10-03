package com.exam.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.exam.entity.BookEntity;
import com.exam.entity.ReviewEntity;
import com.exam.model.Book;
import com.exam.model.Review;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class BookServiceImpl implements BookService {
	private String fileName = "test.json";

	public List<Book> readJson() throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		List<Book> books = objectMapper.readValue(new File(fileName), new TypeReference<List<Book>>() {});
		return books;
	}

	public List<BookEntity> populateEntity(List<Book> books) {
		List<BookEntity> bookEntities = new ArrayList<BookEntity>();
		books.forEach(book ->{
			BookEntity bookEntity = new BookEntity();
			bookEntity.setTitle(book.getTitle());
			bookEntity.setAuthor(book.getAuthor());
			bookEntity.setPublishedDate(book.getPublishedDate());
			bookEntity.setIsbn(book.getIsbn());
			List<ReviewEntity> reviewEntities = new ArrayList<ReviewEntity>();
			
			book.getReviews().forEach(review -> {
				ReviewEntity reviewEntity = new ReviewEntity();
				reviewEntity.setReviewerName(review.getReviewerName());
				reviewEntity.setContent(review.getContent());
				reviewEntity.setRating(review.getRating());
				reviewEntity.setPublishedDate(review.getPublishedDate());
				reviewEntity.setBookEntity(bookEntity);
				reviewEntities.add(reviewEntity);
			});
			
			bookEntity.setReviewEntities(reviewEntities);
			bookEntities.add(bookEntity);
		});
		return bookEntities;
	}
	
	public Book populateModel(BookEntity bookEntity) {
		Book book = new Book();
		book.setTitle(bookEntity.getTitle());
		book.setAuthor(bookEntity.getAuthor());
		book.setPublishedDate(bookEntity.getPublishedDate());
		book.setIsbn(bookEntity.getIsbn());
		
		List<Review> reviews = new ArrayList<>();
		bookEntity.getReviewEntities().forEach(reviewEntity ->{
			Review review = new Review();
			review.setReviewerName(reviewEntity.getReviewerName());
			review.setContent(reviewEntity.getContent());
			review.setRating(reviewEntity.getRating());
			review.setPublishedDate(reviewEntity.getPublishedDate());
			reviews.add(review);
		});
		
		book.setReviews(reviews);
		return book;
//		List<Book> books = new ArrayList<Book>();
//		bookEntities.forEach(bookEntity ->{
//			Book book = new Book();
//			book.setTitle(bookEntity.getTitle());
//			book.setAuthor(bookEntity.getAuthor());
//			book.setPublishedDate(bookEntity.getPublishedDate());
//			book.setIsbn(bookEntity.getIsbn());
//			List<Review> reviews = new ArrayList<Review>();
//			
//			bookEntity.getReviewEntities().forEach(reviewEntity -> {
//				Review review = new Review();
//				review.setReviewerName(reviewEntity.getReviewerName());
//				review.setContent(reviewEntity.getContent());
//				review.setRating(reviewEntity.getRating());
//				review.setPublishedDate(reviewEntity.getPublishedDate());
//				reviews.add(review);
//			});
//			
//			book.setReviews(reviews);
//			books.add(book);
//		});
//		return books;
	}

}
