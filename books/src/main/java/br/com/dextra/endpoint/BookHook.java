package br.com.dextra.endpoint;

import java.util.List;


import io.yawp.repository.hooks.Hook;


public class BookHook extends Hook<Book>{
	@Override
	public void beforeSave(Book book){
		
		List<Book> listbook=(List) yawp(Book.class).where("name", "=", book.getName()).list();
	
		if(!listbook.isEmpty()){
			if (listbook.get(0).getAuthor() == book.getAuthor())
				listbook.get(0).setQtd(listbook.get(0).getQtd()+1);
		}
	}

}
