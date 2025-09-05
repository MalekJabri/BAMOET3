package org.acme.numbers;

import java.util.Random;
import java.util.stream.Collectors;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/numbers")
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class NumbersResource {

    private Random rand;

    @PostConstruct
    void init() {
        rand = new Random();
    }

    @GET
    @Path("random")
    public Response getRandom(@QueryParam("bound") @DefaultValue("10") int bound) {
        return fromNumber(rand.nextInt(bound));
    }

    @POST
    @Path("{number}/multiplyByAndSum")
    public Response multiplyByAndSum(@PathParam("number") int multiplier, Numbers numbers) {
        return fromNumber(numbers.getNumbers().stream().map(n -> n.intValue() * multiplier).collect(Collectors.summingInt(Integer::intValue)));
    }

    private Response fromNumber(int number) {
        return Response.ok().entity(number).build();
    }

}
