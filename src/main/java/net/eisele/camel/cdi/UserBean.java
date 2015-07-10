package net.eisele.camel.cdi;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author myfear
 */
@RequestScoped
@Named
public class UserBean {

    private String name;

    @Inject
    HelloCamel helloCamel;

    public String getName() {
        return helloCamel.doSomeWorkFor("JSF");
    }

    public void setName(String name) {
        this.name = name;
    }

}
