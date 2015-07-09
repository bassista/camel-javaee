/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.eisele.camel.cdi;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.cdi.ContextName;

/**
 * REST Web Service
 *
 * @author myfear
 */
@Path("hello")
@RequestScoped
public class HelloResource {

    private final static Logger LOGGER = Logger.getLogger(HelloResource.class.getName());

    @Inject
    @ContextName("cdi-context")
    private CamelContext camelctx;

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
        ProducerTemplate producer = camelctx.createProducerTemplate();
        String result = producer.requestBody("direct:start", "JAX-RS", String.class);
        LOGGER.log(Level.INFO, ">> {0}", result);

        return Json.createObjectBuilder().add("Greeting", result).build();

    }

}
