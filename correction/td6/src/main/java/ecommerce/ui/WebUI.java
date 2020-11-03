package org.gradle.demo;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ecommerce.application.BasketServiceOptim;
import ecommerce.application.BasketServiceOptim;
import ecommerce.infra.BasketRepositoryInMemory;

import java.io.IOException;

@WebServlet(name = "WebUI", urlPatterns = {"create"}, loadOnStartup = 1) 
public class WebUI extends HttpServlet {
    private BasketServiceOptim applicationLayer;
    public WebUI() {
        super();
        this.applicationLayer = new BasketServiceOptim(new BasketRepositoryInMemory() );
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            int basketId = this.applicationLayer.createBasket();
            response.getWriter().print("Basket "+basketId+ " has been created");
    }
    
}