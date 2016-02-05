package br.com.dextra.action;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import com.google.appengine.repackaged.com.google.gson.Gson;
import com.google.appengine.repackaged.com.google.gson.reflect.TypeToken;
import com.google.gson.JsonObject;

import br.com.dextra.BaseTestCase;

public class LoanActionTest extends BaseTestCase {

	@Test
	public void testDevolve() throws Exception {
		JsonObject jsonUser = new JsonObject();
		jsonUser.addProperty("email", "renan@gmail.com");
		jsonUser.addProperty("nickname", "renan_coder");

		String res = post("/user", jsonUser.toString());

		JsonObject jsonBook = new JsonObject();

		jsonBook.addProperty("name", "50 tons de cinza");
		jsonBook.addProperty("author", "Stephen King");
		jsonBook.addProperty("qtd", 1);

		Map<String, String> post = new Gson().fromJson(
				post("/book", jsonBook.toString()),
				new TypeToken<Map<String, String>>() {
				}.getType());
		String idBook = post.get("id");

		JsonObject jsonLoan = new JsonObject();
		jsonLoan.addProperty("email", "renan@gmail.com");

		Map<String, String> theLoan = new Gson().fromJson(
				post(idBook + "/borrow", jsonLoan.toString()),
				new TypeToken<Map<String, String>>() {
				}.getType());
		String theLoanId = theLoan.get("id");

		String result = put(theLoanId + "/devolve");

		assertEquals("false", result);

	}

}
