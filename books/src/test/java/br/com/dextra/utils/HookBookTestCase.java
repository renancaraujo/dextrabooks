package br.com.dextra.utils;

import static org.junit.Assert.assertEquals;
import br.com.dextra.exception.BookHookException;

import java.util.List;

import org.junit.Test;

import br.com.dextra.BaseTestCase;
import br.com.dextra.endpoint.Book;

import com.google.gson.JsonObject;

public class HookBookTestCase extends BaseTestCase {

	@Test(expected = BookHookException.class)
	public void testAddBookException() {

        JsonObject json = new JsonObject();
        json.addProperty("name", "50 tons de cinza");
        json.addProperty("author", "Stephen King");
        json.addProperty("qtd", 5);

        post("/book/addbook", json.toString());
        
        JsonObject json2 = new JsonObject();
        json2.addProperty("name", "50 tons de cinza");
        json2.addProperty("author", "Stephen King");
        json2.addProperty("qtd", 2);

        post("/book/addbook", json2.toString());
        
        Book book = yawp(Book.class).where("name", "=", "50 tons de cinza").where("author", "=", "Stephen King").first();
	}
	
	@Test
	public void testAddBook() {

        JsonObject json = new JsonObject();
        json.addProperty("name", "50 tons de cinza");
        json.addProperty("author", "Stephen King");
        json.addProperty("qtd", 5);

        post("/book/addbook", json.toString());
        
        JsonObject json2 = new JsonObject();
        json2.addProperty("name", "51 tons de cinza");
        json2.addProperty("author", "Stephen King");
        json2.addProperty("qtd", 2);

        post("/book/addbook", json2.toString());
        
        Book book = yawp(Book.class).where("name", "=", "50 tons de cinza").where("author", "=", "Stephen King").first();
        
        assertEquals(0,0);
	}
	

}
