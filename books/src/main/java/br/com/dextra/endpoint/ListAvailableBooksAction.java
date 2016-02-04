package br.com.dextra.endpoint;

import java.util.List;

import io.yawp.commons.http.annotation.GET;
import io.yawp.repository.actions.Action;

public class ListAvailableBooksAction extends Action<Book>  {
	
	@GET("see")
	public List<Book> seeList(){
		List<Book> list = yawp(Book.class).where("qtd", ">", 0).list();
		
		return list;
		
	}
}
