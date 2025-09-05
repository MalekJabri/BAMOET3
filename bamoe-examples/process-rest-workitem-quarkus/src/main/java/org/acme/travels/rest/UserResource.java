package org.acme.travels.rest;

import org.acme.travels.User;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/v2")
public class UserResource {

    @Inject
    UserService userService;

    @GET
    @Path("/user/{username}")
    @Produces("application/json")
    public User getUser(@PathParam("username") String username) {
        return userService.getUser(username);
    }
}
