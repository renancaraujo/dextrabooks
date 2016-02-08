package br.com.dextra.endpoint;


import io.yawp.repository.IdRef;
import io.yawp.repository.annotations.Endpoint;
import io.yawp.repository.annotations.Id;
import io.yawp.repository.annotations.Index;
import io.yawp.repository.annotations.ParentId;

@Endpoint(path = "/loan")
public class Loan {

    @Id
    private IdRef<Loan> id;

    @Index
    private IdRef<Book> idBook;
    private IdRef<User> idUser; 
    private boolean active=true;

    public IdRef<Loan> getId() {
        return id;
    }
    public Loan(){}
    
    public Loan(IdRef<Book> idBook, IdRef<User> idUser){
    	this.idBook = idBook;
    	this.idUser = idUser;
    }

    public void setId(IdRef<Loan> id) {
        this.id = id;
    }

	public IdRef<Book> getIdBook() {
		return idBook;
	}

	public void setIdBook(IdRef<Book> idLivro) {
		this.idBook = idLivro;
	}

	public IdRef<User> getIdUser() {
		return idUser;
	}

	public void setIdUser(IdRef<User> idUser) {
		this.idUser = idUser;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	

    
}