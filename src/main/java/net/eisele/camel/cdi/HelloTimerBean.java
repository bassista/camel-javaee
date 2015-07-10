package net.eisele.camel.cdi;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;

/**
 *
 * @author myfear
 */
@Singleton
public class HelloTimerBean {

    @Inject
    HelloCamel helloCamel;

    @Schedule(hour = "*", minute = "*", second = "0")
    public void doStuff() {
        helloCamel.doSomeWorkFor("Timer");
    }
}
