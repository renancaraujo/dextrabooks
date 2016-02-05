package br.com.dextra.action;

import br.com.dextra.endpoint.Book;
import br.com.dextra.endpoint.Loan;
import io.yawp.commons.http.annotation.DELETE;
import io.yawp.commons.http.annotation.POST;
import io.yawp.repository.IdRef;
import io.yawp.repository.actions.Action;

public class LoanAction extends Action<Loan> {
	
	@DELETE("devolve")
	public String devolve(IdRef<Loan> idLoan) throws Exception {
		
		Loan loan = yawp(Loan.class).fetch(idLoan);
		
		IdRef<Book> idLivro = loan.getIdLivro();
		Book theBook = yawp(Book.class).fetch(idLivro);

		theBook.setQtd(theBook.getQtd() + 1);

		yawp.save(theBook);
		yawp.destroy(loan.getId());

		return loan.getId().toString();
	}
}
