package org.plugface.demo.plugins.math;

import org.plugface.core.annotations.Plugin;
import org.plugface.demo.app.sdk.Mathematics;

import javax.inject.Inject;

@Plugin("math")
public class MathPlugin implements Mathematics {

    private final SumPlugin sum;
    private final MultPlugin mult;

    @Inject
    public MathPlugin(SumPlugin sum, MultPlugin mult) {
        this.sum = sum;
        this.mult = mult;
    }

    @Override
    public Integer sum(int a, int b) {
        return sum.sum(a, b);
    }

    @Override
    public Integer mult(int a, int b) {
        return mult.mult(a, b);
    }
}
