package br.com.dextra.action;

import java.util.List;

import br.com.dextra.endpoint.Book;
import br.com.dextra.endpoint.Loan;
import io.yawp.commons.http.annotation.GET;
import io.yawp.commons.http.annotation.PUT;
import io.yawp.repository.IdRef;
import io.yawp.repository.actions.Action;

public class LoanAction extends Action<Loan> {

	@PUT("devolve")
	public boolean devolve(IdRef<Loan> idLoan) throws Exception {

		Loan theLoan = yawp(Loan.class).fetch(idLoan);

		theLoan.setActive(false);

		IdRef<Book> idBook = theLoan.getIdBook();
		Book theBook = yawp(Book.class).fetch(idBook);

		theBook.setQtd(theBook.getQtd() + 1);

		yawp.save(theBook);
		yawp.save(theLoan);

		return theLoan.isActive();
	}
	
	@GET("all")
	public List<Loan> listAll() {
		return yawp(Loan.class).list();
	}
}
