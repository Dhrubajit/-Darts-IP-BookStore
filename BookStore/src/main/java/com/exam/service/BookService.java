package com.exam.service;

import java.io.IOException;
import java.util.List;

import com.exam.model.Book;


public interface BookService {
	public List<Book> readJson() throws IOException;
}
