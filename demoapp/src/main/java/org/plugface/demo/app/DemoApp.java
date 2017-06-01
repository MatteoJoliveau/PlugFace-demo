package org.plugface.demo.app;

import com.google.common.io.Resources;
import org.plugface.demo.appsdk.Arithmetic;
import org.plugface.demo.appsdk.Strings;
import org.plugface.demo.plugins.arithmetic.ArithmeticPlugin;
import org.plugface.demo.plugins.string.StringPlugin;
import org.plugface.impl.DefaultPluginContext;
import org.plugface.impl.DefaultPluginManager;

import java.util.List;
import java.util.Map;

public class DemoApp {
    public static void main(String[] args) throws Exception {
        String path = Resources.getResource("plugins").getFile();

        DefaultPluginManager pluginManager = new DefaultPluginManager("manager-1", new DefaultPluginContext());
        pluginManager.loadPlugins(path, true);

        Map<String, Boolean> result = pluginManager.enableAllPlugins();

        for (Map.Entry<String, Boolean> entry : result.entrySet()) {
            if (!entry.getValue()) {
                System.err.println(String.format("Plugin %s wasn't enabled", entry.getKey()));
            }
        }

        List<Arithmetic> arPlugins = pluginManager.getAllImplementingPlugin(Arithmetic.class);
        for (Arithmetic plugin : arPlugins) {
            if (plugin.sum(1, 2) != 3) {
                throw new Exception();
            }
            if (plugin.mult(2, 2) != 4) {
                throw new Exception();
            }
            if (plugin.sub(4, 2) != 2) {
                throw new Exception();
            }
            if (plugin.div(8, 4) != 2) {
                throw new Exception();
            }
        }

        List<Strings> stringPlugins = pluginManager.getAllImplementingPlugin(Strings.class);
        for (Strings plugin : stringPlugins) {
            if (plugin.execute("hello") != 5) {
                throw new Exception();
            }
            if (!"olleh".equals(plugin.invert("hello"))) {
                throw new Exception();
            }
            if (!"Hello".equals(plugin.split("Hello, how are you", ",")[0])) {
                throw new Exception();
            }
        }
    }
}
