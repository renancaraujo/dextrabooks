package br.com.dextra.hook;

import java.util.List;

import br.com.dextra.endpoint.User;
import br.com.dextra.exception.DoubleUserException;
import io.yawp.repository.hooks.Hook;

public class UserHook  extends Hook<User>{
	@Override
	public void beforeSave(User user){
		String theEmail = user.getEmail();
		
		List<User> userWithThisEmail = yawp(User.class).where("email", "=", theEmail).list();
		if(!userWithThisEmail.isEmpty()) throw new DoubleUserException("Email já cadastrado!");
	}

}
