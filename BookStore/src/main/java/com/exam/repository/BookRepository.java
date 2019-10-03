package com.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.exam.model.Book;


public interface BookRepository extends CrudRepository<Book, Integer> {
	
	public static final String FIND_BY_TITLE = "SELECT b FROM Book b where b.title = ?1"; 
			
	@Query(value = FIND_BY_TITLE, nativeQuery = true)
	public List<Book> findByTitle(String title);
}
