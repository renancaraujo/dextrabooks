package br.com.dextra.endpoint;

import io.yawp.repository.IdRef;
import io.yawp.repository.annotations.Endpoint;
import io.yawp.repository.annotations.Id;
import io.yawp.repository.annotations.Index;

@Endpoint(path = "/sample")
public class SampleEndpoint {

    @Id
    private IdRef<SampleEndpoint> id;

    @Index
    private String desc;
    private int value;

    public IdRef<SampleEndpoint> getId() {
        return id;
    }

    public void setId(IdRef<SampleEndpoint> id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
