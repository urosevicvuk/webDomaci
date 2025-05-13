package rs.raf;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class HelloApplication extends Application {
    // The application class is empty because we are using JAX-RS to create a RESTful web service.
    // The @ApplicationPath annotation specifies the base URI for all resource URIs provided by this application.
    // In this case, the base URI is "/api".
    // The Application class is a JAX-RS class that serves as a configuration class for the application.
    // It can be used to register resources and providers, but in this case, we are not registering any additional resources or providers.

    private String secret = "giantdad";

    public static String getSecret() {
        return secret;
    }


}