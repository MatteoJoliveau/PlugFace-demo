package org.plugface.demo.plugins.math;

import org.plugface.core.annotations.Plugin;

@Plugin("mult")
public class MultPlugin {

    Integer mult(int a, int b) {
        return a * b;
    }
}
