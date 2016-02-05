package br.com.dextra.action;

import java.util.Map;

import com.google.gson.Gson;

import io.yawp.commons.http.annotation.POST;
import io.yawp.repository.IdRef;
import io.yawp.repository.actions.Action;
import br.com.dextra.endpoint.Book;
import br.com.dextra.endpoint.Loan;
import br.com.dextra.endpoint.User;
import br.com.dextra.exception.MyMessageException;
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
}
