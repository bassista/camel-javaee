/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.eisele.camel.cdi;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.cdi.ContextName;

/**
 *
 * @author myfear
 */
@WebServlet(name = "HelloServlet", urlPatterns = {"/*"}, loadOnStartup = 1)
public class HelloServlet extends HttpServlet {

    private final static Logger LOGGER = Logger.getLogger(HelloServlet.class.getName());

    @Inject
    @ContextName("cdi-context")
    private CamelContext camelctx;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        ServletOutputStream out = res.getOutputStream();
        ProducerTemplate producer = camelctx.createProducerTemplate();
        String result = producer.requestBody("direct:start", name, String.class);
        LOGGER.log(Level.INFO, ">> {0}", result);
        out.print(result);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
