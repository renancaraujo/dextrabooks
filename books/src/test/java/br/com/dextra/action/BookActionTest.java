package br.com.dextra.action;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.gson.JsonObject;

import br.com.dextra.BaseTestCase;

public class BookActionTest extends BaseTestCase{

	@Test
	public void testBorrow() {
		JsonObject json = new JsonObject();
        json.addProperty("email", "renan.oi@hotmail.com");

        String post = from(post("/book/16/borrow", json.toString()), String.class);
        assertEquals(8, post);
        
        
	}
}
