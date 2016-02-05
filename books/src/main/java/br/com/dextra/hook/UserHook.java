package br.com.dextra.hook;

import br.com.dextra.endpoint.Book;
import br.com.dextra.endpoint.User;
import io.yawp.repository.hooks.Hook;

public class UserHook  extends Hook<User>{
	@Override
	public void beforeSave(User user){
		
	}

}
