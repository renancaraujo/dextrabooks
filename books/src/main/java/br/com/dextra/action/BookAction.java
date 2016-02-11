package br.com.dextra.action;


import java.util.List;

import io.yawp.commons.http.annotation.DELETE;
import io.yawp.commons.http.annotation.GET;
import io.yawp.commons.http.annotation.POST;
import io.yawp.commons.http.annotation.PUT;
import io.yawp.repository.IdRef;
import io.yawp.repository.actions.Action;
import br.com.dextra.endpoint.Book;
import br.com.dextra.endpoint.Loan;
import br.com.dextra.endpoint.User;
import br.com.dextra.exception.BookHookException;
import br.com.dextra.exception.NoBookAvaliableException;
import br.com.dextra.exception.UserNotExistsException;

public class BookAction extends Action<Book> {

	@POST("borrow")
	public Loan borrow(IdRef<Book> idLivro, User user) throws Exception {

		Book theBook = yawp(Book.class).fetch(idLivro);
		try{
			User theUser = yawp(User.class).where("email", "=", user.getEmail())
					.only();
			if (theBook.getQtd() <= 0)
				throw new NoBookAvaliableException("Livro indisponivel");

			IdRef<User> idUser = theUser.getId();
			Loan myLoan = new Loan(idLivro, idUser);
			theBook.setQtd(theBook.getQtd() - 1);

			yawp.save(theBook);

			return yawp.save(myLoan);
		}catch(RuntimeException e){
			throw new UserNotExistsException("Usuario nao existe!");
		}
		

		
	}
	
	@POST("addbook")
	public Book addBook(Book book){

		Book oldbook = yawp(Book.class).where("name", "=", book.getName()).where("author", "=", book.getAuthor()).first();
		
		if (oldbook != null) {
			int qtd = oldbook.getQtd() + book.getQtd();
			book.setQtd(qtd);
			String retorno = "{\"errordescription\": \"Livro já existe, atualizando\",\"idlivro\": \"" + oldbook.getId() + "\"}"; 
			updateBook(oldbook.getId(), book);
			throw new BookHookException(retorno);
		}
		return yawp.save(book);
		
	}
	
	@GET("loans")
	public List<Loan> LoanListUser(IdRef<Book>  book){
		return yawp(Loan.class).where("idBook", "=", book).list();
	}
	
	@PUT("update")
	public void updateBook(IdRef<Book> idBook, Book book){
		Book oldbook = yawp(Book.class).fetch(idBook);
		oldbook.setAuthor(book.getAuthor());
		oldbook.setName(book.getName());
		oldbook.setQtd(book.getQtd());
		yawp.save(oldbook);
	}
	
	@GET("all")
	public List<Book> listAll() {
		return yawp(Book.class).list();
	}
	
	@DELETE("delete")
	public void deleteBook(IdRef<Book> idBook){
		yawp.destroy(idBook);
	}
	@GET("info")
	public Book infoBook(IdRef<Book> idBook){
		return yawp(Book.class).fetch(idBook);
	}
}