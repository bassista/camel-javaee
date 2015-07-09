package net.eisele.camel.cdi;

import javax.inject.Named;

/**
 *
 * @author myfear
 */
@Named
public class HelloBean {

    public String sayHello() {
        return "Hello ";
    }

}
