package br.com.dextra.shield;

import io.yawp.commons.http.annotation.DELETE;
import io.yawp.commons.http.annotation.GET;
import io.yawp.commons.http.annotation.POST;
import io.yawp.commons.http.annotation.PUT;
import io.yawp.repository.IdRef;
import io.yawp.repository.shields.Shield;
import br.com.dextra.endpoint.Book;
import br.com.dextra.endpoint.User;

public class BookShield extends Shield<Book> {

	@POST("borrow")
	public void borrow(IdRef<Book> idLivro, User user) {
		allow(true);
	}

	@POST("addbook")
	public void addBook(Book book) {
		allow(true);
	}

	@GET("loans")
	public void LoanListUser(IdRef<Book> book) {
		allow(true);
	}
	@PUT("update")
	public void updateBook(IdRef<Book> idBook, Book book) {
		allow(true);
	}
	@GET("all")
	public void listAll() {
		allow(true);
	}
	@DELETE("delete")
	public void deleteBook(IdRef<Book> idBook){
		allow(true);
	}
	@GET("info")
	public void infoBook(IdRef<Book> idBook){
		allow(true);
	}
}
