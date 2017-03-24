package org.plugface.demo.plugins.arithmetic;

import org.plugface.SimplePlugin;
import org.plugface.demo.sdk.ArithmeticPlugin;

public class CountingPlugin extends SimplePlugin implements ArithmeticPlugin {

    public CountingPlugin() {
        super("countingPlugin");
    }

    public void start() {

    }

    public void stop() {

    }

    public int sum(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int div(int a, int b) {
        return a / b;
    }

    public int mul(int a, int b) {
        return a * b;
    }
}
