package br.com.dextra.endpoint;

import io.yawp.repository.IdRef;
import io.yawp.repository.annotations.Endpoint;
import io.yawp.repository.annotations.Id;
import io.yawp.repository.annotations.Index;

@Endpoint(path = "/book")
public class Book {

    @Id
    private IdRef<Book> id;

    @Index
    private String name;
    private String author;
    private int qtd;

    public IdRef<Book> getId() {
        return id;
    }

    public void setId(IdRef<Book> id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.qtd = qtd;
    }
    
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.name = name;
    }
}