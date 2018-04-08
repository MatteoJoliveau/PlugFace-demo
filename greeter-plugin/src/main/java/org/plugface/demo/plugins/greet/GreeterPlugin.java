package org.plugface.demo.plugins.greet;

import org.plugface.core.annotations.Plugin;
import org.plugface.demo.app.sdk.Greeter;
import org.plugface.demo.app.sdk.TestService;

import javax.inject.Inject;

@Plugin("greeter")
public class GreeterPlugin implements Greeter {

    private final TestService test;

    @Inject
    public GreeterPlugin(TestService test) {
        this.test = test;
    }

    @Override
    public String greet() {
        return "Hello PlugFace! " + test.test();
    }
}
