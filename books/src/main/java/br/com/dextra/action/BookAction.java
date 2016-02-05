package br.com.dextra.action;

import io.yawp.commons.http.annotation.DELETE;
import io.yawp.commons.http.annotation.POST;
import io.yawp.commons.http.annotation.PUT;
import io.yawp.repository.IdRef;
import io.yawp.repository.actions.Action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import br.com.dextra.endpoint.Book;
import br.com.dextra.endpoint.Loan;
import br.com.dextra.endpoint.User;

import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

public class BookAction extends Action<Book> {
	
	@POST("borrow")
	public void borrow(IdRef<Book> idLivro, User user) throws Exception {
		
		Book theBook = yawp(Book.class).fetch(idLivro);
		User theUser = yawp(User.class).where("email", "=", user.getEmail()).only();
		
		if(theBook.getQtd() <= 0) throw new Exception("Livro indisponivel");
		
		
		IdRef<User> idUser = theUser.getId();
		Loan myLoan = new Loan(idLivro, idUser);
		
		theBook.setQtd(theBook.getQtd() - 1);

		
		yawp.save(theBook);
		yawp.save(myLoan);
	}
}
