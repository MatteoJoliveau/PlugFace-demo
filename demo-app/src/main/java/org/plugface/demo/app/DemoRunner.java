package org.plugface.demo.app;

import lombok.extern.slf4j.Slf4j;
import org.plugface.core.PluginManager;
import org.plugface.core.factory.PluginSources;
import org.plugface.demo.app.sdk.Greeter;
import org.plugface.demo.app.sdk.Mathematics;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;

@Slf4j
@Service
public class DemoRunner {

    private final PluginManager manager;
    private final URI pluginFolder;

    public DemoRunner(PluginManager manager, @Value("classpath:/plugins")Resource pluginFolder) throws IOException {
        this.manager = manager;
        this.pluginFolder = pluginFolder.getURI();
    }

    public void run() throws Exception {

        manager.loadPlugins(PluginSources.jarSource(pluginFolder));

        final Mathematics math = manager.getPlugin(Mathematics.class);

        final Greeter greeter = manager.getPlugin(Greeter.class);

        log.info("Hello from a plugin: {}", greeter.greet());
        log.info("5 + 10 = {}", math.sum(5, 10));
        log.info("5 * 10 = {}", math.mult(5, 10));
    }
}
