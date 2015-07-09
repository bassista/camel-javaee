/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.eisele.camel.cdi;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;

/**
 *
 * @author myfear
 */
@Stateless
public class HelloTimerBean {

    private final static Logger LOGGER = Logger.getLogger(HelloTimerBean.class.getName());

    @Resource(name = "java:jboss/camel/context/cdi-context")
    CamelContext context;

    @Schedule(hour = "*", minute = "*", second = "*/30")
    public void doStuff() {

        ProducerTemplate producer = context.createProducerTemplate();
        String result = producer.requestBody("direct:start", "Timer", String.class);
        LOGGER.log(Level.INFO, ">> {0}", result);

    }
}
