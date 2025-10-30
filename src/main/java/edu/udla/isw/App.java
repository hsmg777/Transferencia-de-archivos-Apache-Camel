package edu.udla.isw;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;

public class App extends RouteBuilder {

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.configure().addRoutesBuilder(new App());
        main.run(args);
    }

    @Override
    public void configure() {

        // Ajusta BASE_DIR si deseas otra ruta
        final String BASE_DIR = System.getProperty("user.home") + "/Desarrollo/IntegracionSistemas/camel-labs/lab01";

        from("file:" + BASE_DIR + "/input?noop=true")
            .routeId("file-transfer-lab01")
            .log("Procesando archivo: ${file:name}")
            .to("file:" + BASE_DIR + "/output");
    }
}
