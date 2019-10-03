package com.exam.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.exam.entity.BookEntity;
import com.exam.model.Book;
import com.exam.model.Input;
import com.exam.repository.BookRepository;
import com.exam.service.BookService;


@Path("/bookStore")
public class BookResource extends BaseResource {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private BookRepository bookRepo;
	
	
	@GET
	@Path("/viewAll")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response viewAll() {
		Response response;
		try {
			List<Book> books = bookService.readJson();
			response = Response.status(Status.OK).entity(books).build();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(this.getResponseFromError(ex, Status.INTERNAL_SERVER_ERROR)).build();
		}
		return response;
	}
	
		
	@PUT
	@Path("/saveAll")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveAll() {
		Response response;
		try {
			List<Book> books = bookService.readJson();
			List<BookEntity> bookEntities = bookService.populateEntity(books);
			bookRepo.saveAll(bookEntities);
			response = Response.status(Status.OK).entity(books).build();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(this.getResponseFromError(ex, Status.INTERNAL_SERVER_ERROR)).build();
		}
		return response;
	}
	
	
	@GET
	@Path("/getByTitle")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getByTitle(Input input) {
		Response response;
		try {
			if(null==input || StringUtils.isEmpty(input.getTitle())) {
				response = Response.status(Status.BAD_REQUEST).entity(this.getResponseFromError(new Exception("title cannot be blank"), Status.BAD_REQUEST)).build();
				return response;
			}
			BookEntity bookEntity = bookRepo.findByTitle(input.getTitle());
			response = Response.status(Status.CREATED).entity(bookService.populateModel(bookEntity)).build();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(this.getResponseFromError(ex, Status.INTERNAL_SERVER_ERROR)).build();
		}
		return response;
	} 
	
}


