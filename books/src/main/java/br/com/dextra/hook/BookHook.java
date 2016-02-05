package br.com.dextra.hook;

import java.util.List;

import br.com.dextra.endpoint.Book;
import br.com.dextra.exception.BookHookException;
import io.yawp.commons.http.HttpException;
import io.yawp.repository.hooks.Hook;


public class BookHook extends Hook<Book>{
	
	@Override
	public void beforeSave(Book newbook) {
		Book oldbook = yawp(Book.class).where("name", "=", newbook.getName()).where("author", "=", newbook.getAuthor()).first();
		
		if (oldbook != null) {
			throw new BookHookException("Livro já existente. (ID: " + oldbook.getId() + ").");
		}
	}

}
