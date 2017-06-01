package org.plugface.demo.plugins.arithmetic;

import org.plugface.Plugin;
import org.plugface.PluginConfiguration;
import org.plugface.PluginStatus;
import org.plugface.demo.appsdk.Arithmetic;
import org.plugface.impl.DefaultPluginConfiguration;

import java.util.Collections;

public class ArithmeticPlugin implements Plugin<Integer[], Integer>, Arithmetic {

    private final String name;
    private PluginConfiguration configuration;
    private PluginStatus status;
    private boolean enabled;

    public ArithmeticPlugin() {
        name = "name";
        configuration = new DefaultPluginConfiguration();
        status = PluginStatus.READY;
        enabled = false;
    }

    public void start() {
        throw new UnsupportedOperationException("This plugin operates in single mode only");
    }

    public void stop() {
        throw new UnsupportedOperationException("This plugin operates in single mode only");
    }

    public Integer execute(Integer[] parameters) {

        Integer sum = 0;

        for (Integer i : parameters) {
            sum += i;
        }
        return sum;
    }

    public PluginConfiguration getPluginConfiguration() {
        return (PluginConfiguration) Collections.unmodifiableMap(configuration);
    }

    public void setPluginConfiguration(PluginConfiguration configuration) {
        this.configuration = configuration;
    }

    public String getName() {
        return name;
    }

    public PluginStatus getStatus() {
        return status;
    }

    public void setStatus(PluginStatus pluginStatus) {
        status = pluginStatus;
    }

    public void enable() {
        this.enabled = true;
    }

    public void disable() {
        this.enabled = false;
    }

    public boolean isEnabled() {
        return enabled ;
    }

    public Integer sum(Integer... numbers) {
        Integer total = 0;
        for (Integer i : numbers) {
            total += i;
        }
        return total;
    }

    public Integer sub(Integer... numbers) {
        Integer total = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            total -= numbers[i];
        }

        return total;
    }

    public Integer mult(Integer... numbers) {
        Integer total = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            total *= numbers[i];
        }
        return total;
    }

    public Integer div(Integer... numbers) {
        Integer total = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            total /= numbers[i];
        }
        return total;
    }
}
