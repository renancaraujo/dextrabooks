package br.com.dextra.endpoint;

import io.yawp.repository.IdRef;
import io.yawp.repository.annotations.Endpoint;
import io.yawp.repository.annotations.Id;
import io.yawp.repository.annotations.Index;

@Endpoint(path = "/user")
public class User {

    @Id
    private IdRef<User> id;

    @Index
    private String email;
    @Index
    private String nickname;

    public IdRef<User> getId() {
        return id;
    }

    public void setId(IdRef<User> id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String email) {
        this.email = email;
    }
    
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
