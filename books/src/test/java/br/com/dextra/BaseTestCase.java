package br.com.dextra;

import io.yawp.testing.EndpointTestCaseBase;

public class BaseTestCase extends EndpointTestCaseBase {

    @Override
    protected String getAppPackage() {
        return "br.com.dextra";
    }

}
