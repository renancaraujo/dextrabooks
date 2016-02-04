package br.com.dextra.endpoint;

import io.yawp.commons.http.annotation.DELETE;
import io.yawp.commons.http.annotation.POST;
import io.yawp.repository.IdRef;
import io.yawp.repository.actions.Action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class LoanActions extends Action<Loan> {
	@POST("borrow")
	public void borrow(Map<String, String> params) {
		
	}

	@DELETE("devolve")
	public void devolve(IdRef<Loan> theLoan) {
		yawp.destroy(theLoan);
	}

}
