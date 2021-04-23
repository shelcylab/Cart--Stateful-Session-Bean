/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import stateful.BookException;
import stateful.CartBean;
import stateful.CartBeanLocal;

/**
 *
 * @author n01316980
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/CartServlet"})
public class CartServlet extends HttpServlet {

   @EJB
    private CartBeanLocal cart;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        cart = new CartBean();
        
        PrintWriter writer = resp.getWriter();
        try {
            cart.initialize("MY BOOK", "123");
            cart.addBook("Head First");
            cart.addBook("Bean Developer");
            cart.addBook("Street Show");
           
            List bookList = cart.getContents();
           
            Iterator iterator = bookList.iterator();
           
            while(iterator.hasNext())
            {
                String title = (String) iterator.next();
                writer.write("Retrieving book title from cart: " + title+"\n");
            }
           
            writer.write("Removing \"MY BOOK\" from cart\n");
           
            cart.removeBook("MY BOOK");
           
            cart.remove();
           
           
           
        } catch (BookException ex) {
            writer.write("Caught a BookException: " + ex.getMessage());
           
        } catch (Exception ex) {
            writer.write("Caught an unexpected exception!");
            ex.printStackTrace();
           
        }
    }
}
