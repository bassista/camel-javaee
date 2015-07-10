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

    @Inject
    HelloCamel helloCamel;

    private String name;

    public String getName() {

        return helloCamel.doSomeWorkFor("JSF");
    }

    public void setName(String name) {
        this.name = name;
    }

}
