package net.eisele.camel.cdi;

import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;

/**
 * REST Web Service
 *
 * @author myfear
 */
@Path("hello")
@RequestScoped
public class HelloResource {

    @Inject
    HelloCamel helloCamel;

    /**
     * Creates a new instance of HelloResource
     */
    public HelloResource() {
    }

    /**
     * Retrieves representation of an instance of
     * net.eisele.camel.cdi.HelloResource
     *
     * @return an instance of JsonObject
     */
    @GET
    @Produces("application/json")
    public JsonObject getJson() {
        String result = helloCamel.doSomeWorkFor("JAX-RS");
        return Json.createObjectBuilder().add("Greeting", result).build();

    }

}
