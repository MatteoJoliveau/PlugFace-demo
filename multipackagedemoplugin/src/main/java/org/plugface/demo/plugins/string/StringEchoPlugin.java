package org.plugface.demo.plugins.string;

import org.plugface.SimplePlugin;
import org.plugface.demo.sdk.EchoPlugin;

public class StringEchoPlugin extends SimplePlugin implements EchoPlugin {

    public StringEchoPlugin() {
        super("stringEchoPlugin");
    }
    public void start() {

    }

    public void stop() {

    }

    public String echo(String s) {
        return s;
    }
}
