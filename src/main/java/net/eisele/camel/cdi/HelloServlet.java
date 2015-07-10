package net.eisele.camel.cdi;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author myfear
 */
@WebServlet(name = "HelloServlet", urlPatterns = {"/hello/*"}, loadOnStartup = 1)
public class HelloServlet extends HttpServlet {

    @Inject
    HelloCamel helloCamel;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ServletOutputStream out = res.getOutputStream();
        out.print(helloCamel.doSomeWorkFor("Servlet"));
    }

}
