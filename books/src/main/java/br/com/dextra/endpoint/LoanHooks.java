package br.com.dextra.endpoint;

import io.yawp.commons.http.HttpException;
import io.yawp.repository.hooks.Hook;

public class LoanHooks  extends Hook<Loan> {
	
    public void beforeSave(Loan loan) {
    	int qtd = yawp(Book.class).where("id", "=", loan.getIdLivro()).first().getQtd();
        if (qtd == 0) {
            throw new HttpException(422, "Nao ha exemplar disponivel deste livro");
        }
    }
}
