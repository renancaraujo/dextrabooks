package br.com.dextra.action;

import br.com.dextra.BaseTestCase;
import com.google.gson.JsonObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SampleActionTest extends BaseTestCase {

    @Test
    public void testSeeJson() throws Exception {
        JsonObject json = new JsonObject();
        json.addProperty("desc", "Teste");
        json.addProperty("value", 2);

        post("/sample", json.toString());
        String post = from(post("/sample/1/see", json.toString()), String.class);
        assertEquals(json.toString(), post);
    }

    @Test
    public void testSeeUser() throws Exception {
        JsonObject json = new JsonObject();
        json.addProperty("desc", "Teste");
        json.addProperty("value", 2);
        post("/sample", json.toString());

        json = new JsonObject();
        json.addProperty("nickname", "Juca tigre");
        String post = from(post("/sample/1/seeUser", json.toString()), String.class);
        assertEquals("Juca tigre", post);
    }
}