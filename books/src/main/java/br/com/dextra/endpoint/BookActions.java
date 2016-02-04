package br.com.dextra.endpoint;

import io.yawp.commons.http.annotation.DELETE;
import io.yawp.commons.http.annotation.POST;
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
	public void borrow(IdRef<Sample> id, User user) {
		return user.getId();
	}

	@DELETE("devolve")
	public void devolve(IdRef<Loan> theLoan) {
		yawp.destroy(theLoan);
	}

}
