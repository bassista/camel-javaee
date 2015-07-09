/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.eisele.camel.cdi;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.cdi.ContextName;

/**
 *
 * @author myfear
 */
@Named
@RequestScoped
public class UserBean {

    @Inject
    @ContextName("cdi-context")
    private CamelContext camelctx;

    private String name;

    public String getName() {

        if (this.name.equalsIgnoreCase("") || this.name == null) {
            ProducerTemplate producer = camelctx.createProducerTemplate();
            this.name = producer.requestBody("direct:start", "JSF", String.class);
        } else {
            this.name = "test";
        }
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
