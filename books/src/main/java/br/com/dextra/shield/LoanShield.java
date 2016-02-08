package br.com.dextra.shield;

import br.com.dextra.endpoint.Loan;
import io.yawp.commons.http.annotation.GET;
import io.yawp.commons.http.annotation.PUT;
import io.yawp.repository.IdRef;
import io.yawp.repository.shields.Shield;

public class LoanShield extends Shield<Loan>{

	@PUT("devolve")
	public void devolve(IdRef<Loan> idLoan) {
		allow(true);
	}
	
	@GET("all")
	public void listAll() {
		allow(true);
	}

}
