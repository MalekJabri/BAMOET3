package ${package}.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import ${package}.model.rules.RuleResults;
import ${package}.service.${serviceClassName};

@Path("${restPath}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class ${restClassName} {

    private static final Logger logger = LoggerFactory.getLogger(${restClassName}.class);

    @Inject ${serviceClassName} service;

    /*
     * Example REST API Endpoint
     * 
     * Any REST API Endpoint should simply pass the call off to the service class, as well as manage incoming/outgoing HTTP Headers, etc.
     */

    /***************
    @POST()
	@Path("process-customers")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response processCustomers(List<Customer> customers) {

        RuleResults results = service.processCustomers(customers);
        return Response.ok(results).build();
    }
    ***************/
   
}
