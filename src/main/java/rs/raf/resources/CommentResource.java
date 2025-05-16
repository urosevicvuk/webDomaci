package rs.raf.resources;

import rs.raf.entities.Post;
import rs.raf.entities.Comment;
import rs.raf.services.CommentService;
import rs.raf.services.PostService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/comments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {

    @Inject
    private CommentService commentService;
    @Inject
    private PostService postService;

    @GET
    @Path("/{blogPostId}")
    public Response getComments(@PathParam("blogPostId") Integer blogPostId) {
        List<Comment> comments = commentService.getComments(blogPostId);
        return Response.ok(comments).build();
    }

    @POST
    @Path("/{blogPostId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createComment(@PathParam("blogPostId") Integer blogPostId, @Valid Comment comment) {

        Post post=postService.findPost(blogPostId);
        if (post==null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        comment.setBlogPostId(blogPostId);
        Comment saved=commentService.addComment(comment,blogPostId);

        return Response.status(Response.Status.CREATED).entity(saved).build();

    }
}
