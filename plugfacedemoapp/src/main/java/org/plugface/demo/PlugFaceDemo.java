package org.plugface.demo;

import org.plugface.Plugin;
import org.plugface.PluginContext;
import org.plugface.PluginManager;
import org.plugface.demo.sdk.ArithmeticPlugin;
import org.plugface.demo.sdk.EchoPlugin;
import org.plugface.impl.DefaultPluginContext;
import org.plugface.impl.DefaultPluginManager;

import java.util.List;

public class PlugFaceDemo {

    private static final String PLUGINFOLDER = "plugfacedemoapp/target/classes/plugins";
    private static PluginContext context = new DefaultPluginContext();

    public static void main(String[] args) {

        PluginManager manager = new DefaultPluginManager(context);

        manager.setPluginFolder(PLUGINFOLDER);
        manager.loadPlugins(true);

        Plugin<Object, Long> countWordsPlugin = context.getPlugin("countWordsPlugin");
        Long result = countWordsPlugin.execute("Ciao, come va?");
        System.out.println(result);

        List<Plugin> allArithmeticPlugin = manager.getAllImplementingPlugin(ArithmeticPlugin.class);
        List<Plugin> allEchoPlugin = manager.getAllImplementingPlugin(EchoPlugin.class);

        for (Plugin p : allArithmeticPlugin) {
            ArithmeticPlugin a = (ArithmeticPlugin) p;
            System.out.println(a.sum(1, 2));
            System.out.println(a.div(4, 2));
            System.out.println(a.sub(3, 1));
            System.out.println(a.mul(2, 5));
        }

        for (Plugin p : allEchoPlugin) {
            EchoPlugin e = (EchoPlugin) p;
            System.out.println(e.echo("Ciao") + " " + e.echo("a tutti!"));
        }


    }
}
