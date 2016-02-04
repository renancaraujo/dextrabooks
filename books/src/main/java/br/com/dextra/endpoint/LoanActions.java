package br.com.dextra.endpoint;

import io.yawp.commons.http.annotation.DELETE;
import io.yawp.commons.http.annotation.POST;
import io.yawp.repository.IdRef;
import io.yawp.repository.actions.Action;

public class LoanActions extends Action<Loan> {

    @POST
    public Loan borrow(IdRef<Loan> idLivro, User idUser) {
//        Loan novoEmprestimo = new Loan(idLivro, idUser);
//        return yawp.save(novoEmprestimo);
        return null;
    }

    @DELETE
    public void devolve(IdRef<Loan> theLoan) {
        yawp.destroy(theLoan);
    }


}
