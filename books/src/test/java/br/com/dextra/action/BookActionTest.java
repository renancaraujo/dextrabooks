package br.com.dextra.action;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import com.google.appengine.repackaged.com.google.gson.Gson;
import com.google.appengine.repackaged.com.google.gson.reflect.TypeToken;
import com.google.gson.JsonObject;

import br.com.dextra.BaseTestCase;

public class BookActionTest extends BaseTestCase {

	@Test
	public void testBorrow() throws Exception {
		JsonObject jsonUser = new JsonObject();
		jsonUser.addProperty("email", "renan@gmail.com");
		jsonUser.addProperty("nickname", "renan_coder");

		post("/user", jsonUser.toString());

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

		//String activeString = post(idBook + "/borrow", jsonLoan.toString());
		Map<String, String> activeString = new Gson().fromJson(
				post(idBook+"/borrow", jsonLoan.toString()),
				new TypeToken<Map<String, String>>() {
				}.getType());
		String active = activeString.get("active");


		assertEquals("true", active);

	}
}
