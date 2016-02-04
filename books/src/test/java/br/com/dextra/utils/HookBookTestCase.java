package br.com.dextra.utils;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Test;
import br.com.dextra.BaseTestCase;
import br.com.dextra.endpoint.Book;
import com.google.gson.JsonObject;

public class HookBookTestCase extends BaseTestCase {

	@Test
	public void testAddBook() {

        JsonObject json = new JsonObject();
        json.addProperty("name", "50 tons de cinza");
        json.addProperty("author", "Stephen King");
        json.addProperty("qtd", 5);

        post("/book", json.toString());
        
        JsonObject json2 = new JsonObject();
        json2.addProperty("name", "50 tons de cinza");
        json2.addProperty("author", "Stephen King");
        json2.addProperty("qtd", 12);

        post("/book", json2.toString());
        
        List<Book> bookList = yawp(Book.class).where("name", "=", "50 tons de cinza").where("author", "=", "Stephen King").list();
        
        assertEquals(bookList.get(0).getQtd(), 17);
	}

}
