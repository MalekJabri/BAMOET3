package org.acme.travels.rest;

import org.acme.travels.quarkus.User;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/v2")
@RegisterRestClient
public interface UsersRemoteService {

    @GET
    @Path("/user/{username}")
    @Produces("application/json")
    User get(@PathParam("username") String username);
}
