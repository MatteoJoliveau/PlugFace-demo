package org.plugface.demo.plugins.string;

import org.plugface.DefaultPlugin;
import org.plugface.demo.appsdk.Strings;

public class StringPlugin extends DefaultPlugin<String, Integer> implements Strings {
    public StringPlugin() {
        super("string");
    }

    public void start() {
        throw new UnsupportedOperationException("This plugin operates in single mode only");
    }

    public void stop() {
        throw new UnsupportedOperationException("This plugin operates in single mode only");
    }

    public Integer execute(String parameters) {
        return parameters.length();
    }

    public String invert(String string) {
        char[] chars = string.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length-1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    public String[] split(String string, String regex) {
        return string.split(regex);
    }
}
