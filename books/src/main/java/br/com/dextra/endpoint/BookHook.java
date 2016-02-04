package br.com.dextra.endpoint;

import java.util.List;


import io.yawp.repository.hooks.Hook;


public class BookHook extends Hook<Book>{
	@Override
	public void beforeSave(Book book){
		
		List<Book> listbook = yawp(Book.class).where("name", "=", book.getName()).list();
	
		if(!listbook.isEmpty()){
			for (int i = 0; i < listbook.size(); i++) {
				if (listbook.get(i).getAuthor() == book.getAuthor())
					listbook.get(i).setQtd(listbook.get(i).getQtd()+1);
			}
		}
	}

}
