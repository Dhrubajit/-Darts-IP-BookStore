package com.exam.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.exam.entity.BookEntity;


public interface BookRepository extends CrudRepository<BookEntity, Integer> {
	
	public static final String FIND_BY_TITLE = "SELECT * FROM Book b where b.title = ?1"; 
			
	@Query(value = FIND_BY_TITLE, nativeQuery = true)
	public BookEntity findByTitle(String title);
}
