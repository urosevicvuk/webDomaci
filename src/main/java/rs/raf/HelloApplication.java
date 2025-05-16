package rs.raf;

import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import rs.raf.repositories.comment.CommentRepository;
import rs.raf.repositories.comment.DBCommentRepository;
import rs.raf.repositories.comment.MemoryCommentRepository;
import rs.raf.repositories.post.DBPostRepository;
import rs.raf.repositories.post.MemoryPostRepository;
import rs.raf.repositories.post.PostRepository;
import rs.raf.repositories.user.DBUserRepository;
import rs.raf.repositories.user.MemoryUserRepository;
import rs.raf.repositories.user.UserRepository;
import rs.raf.services.CommentService;
import rs.raf.services.PostService;
import rs.raf.services.UserService;

import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class HelloApplication extends ResourceConfig {
    // The application class is empty because we are using JAX-RS to create a RESTful web service.
    // The @ApplicationPath annotation specifies the base URI for all resource URIs provided by this application.
    // In this case, the base URI is "/api".
    // The Application class is a JAX-RS class that serves as a configuration class for the application.
    // It can be used to register resources and providers, but in this case, we are not registering any additional resources or providers.

    public HelloApplication() {
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);

        AbstractBinder binder = new AbstractBinder() {
            @Override
            protected void configure() {
                // Memory repositories
                //this.bind(MemoryPostRepository.class).to(PostRepository.class).in(Singleton.class);
                //this.bind(MemoryCommentRepository.class).to(CommentRepository.class).in(Singleton.class);
                //this.bind(MemoryUserRepository.class).to(UserRepository.class).in(Singleton.class);

                this.bind(DBPostRepository.class).to(PostRepository.class).in(Singleton.class);
                this.bind(DBCommentRepository.class).to(CommentRepository.class).in(Singleton.class);
                this.bind(DBUserRepository.class).to(UserRepository.class).in(Singleton.class);

                this.bindAsContract(PostService.class);
                this.bindAsContract(CommentService.class);
                this.bindAsContract(UserService.class);
            }
        };
        register(binder);

        packages("rs.raf");
    }

    public static String getSecret() {
        return "giantdad";
    }


}