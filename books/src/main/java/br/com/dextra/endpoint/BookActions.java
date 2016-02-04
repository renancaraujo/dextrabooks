package br.com.dextra.endpoint;

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

import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

public class BookActions extends Action<Book> {
	
	@POST("borrow")
	public String borrow(IdRef<Book> idLivro, User user) throws Exception {
		
		Book theBook = yawp(Book.class).fetch(idLivro);
		
		if(theBook.getQtd() <= 0) throw new Exception("Livro indisponivel");
		
		
		IdRef<User> idUser = user.getId();
		Loan myLoan = new Loan(idLivro, idUser);
		
		theBook.setQtd(theBook.getQtd() - 1);

		
		yawp.save(theBook);

		
		return yawp.save(myLoan).getId().toString();
	}

	@POST("devolve")
	public String devolve(IdRef<Book> idLivro, Loan loan) throws Exception {
		
		Book theBook = yawp(Book.class).fetch(idLivro);

		theBook.setQtd(theBook.getQtd() + 1);

		yawp.save(theBook);
		yawp.destroy(loan.getId());

		return loan.getId().toString();
	}

}
