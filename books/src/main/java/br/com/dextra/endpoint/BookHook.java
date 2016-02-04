package br.com.dextra.endpoint;

import java.util.List;
import io.yawp.repository.hooks.Hook;


public class BookHook extends Hook<Book>{
	
	@Override
	public void beforeSave(Book book){
		List<Book> listbook = yawp(Book.class).where("name", "=", book.getName()).list();
		
		if(!listbook.isEmpty()){
			for (int i = 0; i < listbook.size(); i++) {
				if (listbook.get(i).getAuthor().equals(book.getAuthor())) {
					yawp.destroy(yawp(Book.class).fetch(listbook.get(i).getId()).getId());
					int newQtd = listbook.get(i).getQtd()+book.getQtd();
					book.setQtd(newQtd);
				}

			}
		}
	}

}
