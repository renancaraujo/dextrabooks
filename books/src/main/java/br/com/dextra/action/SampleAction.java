package br.com.dextra.action;

import br.com.dextra.endpoint.Sample;
import br.com.dextra.endpoint.User;
import io.yawp.commons.http.annotation.POST;
import io.yawp.repository.IdRef;
import io.yawp.repository.actions.Action;

public class SampleAction extends Action<Sample> {

    @POST("see")
    public String seeJson(IdRef<Sample> id, String json) {
        return json;
    }

    @POST("seeUser")
    public String seeUser(IdRef<Sample> id, User user) {
        return user.getNickname();
    }
}
