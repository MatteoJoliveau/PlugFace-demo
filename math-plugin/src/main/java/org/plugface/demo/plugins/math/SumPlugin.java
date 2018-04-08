package org.plugface.demo.plugins.math;

import org.plugface.core.annotations.Plugin;

@Plugin("sum")
public class SumPlugin {

    Integer sum(int a, int b) {
        return a + b;
    }
}
