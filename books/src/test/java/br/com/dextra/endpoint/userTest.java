package br.com.dextra.endpoint;

import org.junit.Test;

import com.google.gson.JsonObject;
import br.com.dextra.exception.DoubleUserException;
import br.com.dextra.BaseTestCase;

public class userTest extends BaseTestCase {
	@Test(expected = DoubleUserException.class)
	public void testUserBeforeSave() throws Exception {
		JsonObject jsonUser = new JsonObject();
		jsonUser.addProperty("email", "renan@gmail.com");
		jsonUser.addProperty("nickname", "renan_coder");

		post("/user", jsonUser.toString());

		JsonObject jsonUser2 = new JsonObject();
		jsonUser2.addProperty("email", "renan@gmail.com");
		jsonUser2.addProperty("nickname", "renan_coder_two");

		post("/user", jsonUser2.toString());

	}
}
