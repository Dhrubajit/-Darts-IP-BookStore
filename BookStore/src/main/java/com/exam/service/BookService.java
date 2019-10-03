package com.exam.service;

import java.io.IOException;
import java.util.List;

import com.exam.entity.BookEntity;
import com.exam.model.Book;


public interface BookService {
	public List<Book> readJson() throws IOException;
	public List<BookEntity> populateEntity(List<Book> books);
	public Book populateModel(BookEntity bookEntity);
}
