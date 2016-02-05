package br.com.dextra.action;

import io.yawp.commons.http.annotation.GET;
import io.yawp.repository.IdRef;
import io.yawp.repository.actions.Action;

import java.util.List;

import br.com.dextra.endpoint.Loan;
import br.com.dextra.endpoint.User;

public class UserAction extends Action<User> {
	@GET("loans")
	public List<Loan> LoanListUser(IdRef<User>  user){
		return yawp(Loan.class).from(user).list();
	}
}
