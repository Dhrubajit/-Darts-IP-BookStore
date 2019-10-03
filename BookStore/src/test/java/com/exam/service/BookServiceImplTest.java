package com.exam.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.exam.model.Book;


@RunWith(MockitoJUnitRunner.class)
public class BookServiceImplTest {
	
	@InjectMocks
	private BookService bookService = new BookServiceImpl();
	
	@Test
	public void readJsonTest() throws IOException {
		List<Book> books = bookService.readJson();
		assertNotNull(books);
		assertTrue(books.size()>1);
		assertNotNull(books.get(0));
		assertNotNull(books.get(0).getTitle());
		assertNotNull(books.get(0).getReviews());
	}
	
	@Test(expected = Exception.class)
	@SuppressWarnings("unused")
	public void readJsonTest_wrongFileName() throws IOException {
		ReflectionTestUtils.setField(bookService, "fileName", "test1.json");
		List<Book> books = bookService.readJson();
	}
}
