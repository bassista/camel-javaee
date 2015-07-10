package net.eisele.camel.cdi;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.cdi.ContextName;

/**
 *
 * @author myfear
 */
@Named
public class HelloCamel {

    @Inject
    @ContextName("cdi-context")
    private CamelContext context;

    private final static Logger LOGGER = Logger.getLogger(HelloCamel.class.getName());

    public String doSomeWorkFor(String name) {

        ProducerTemplate producer = context.createProducerTemplate();
        String result = producer.requestBody("direct:start", name, String.class);
        LOGGER.log(Level.INFO, result);
        return result;
    }

}
