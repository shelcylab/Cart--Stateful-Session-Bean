/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateful;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 *
 * @author n01316980
 */
@Stateful
public class CartBean implements CartBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    List<String> contents;
    String customerId;
    String customerName;
   
    @Override
    public void initialize(String person) throws BookException {
        if(person==null)
        {
            throw new BookException("Null person not aalowed.");
        }
        else
        {
            customerName = person;
        }
        customerId = "0";
        contents = new ArrayList<String>();
    }

    @Override
    public void initialize(String person, String id) throws BookException {
        if(person==null)
        {
            throw new BookException("Null person not aalowed.");
        }
        else
        {
            customerName = person;           
        }
       
        IdVerifier idChecker = new IdVerifier();
       
        if(idChecker.validate(id))
        {
            customerId = id;
        }
        else
        {
            throw new BookException("Invalid Id: " + id);
        }
       
       
        contents = new ArrayList<String>();
    }

    @Override
    public void addBook(String title) {
        contents.add(title);
    }

    @Override
    public void removeBook(String title) throws BookException {
        boolean result = contents.remove(title);
       
        if(result==false)
        {
            throw new BookException("\"" + title + "\" not in the cart.");
        }
    }

    @Override
    public List<String> getContents() {
        return contents;
    }

    @Remove
    public void remove() {
        contents = null;
    }
   
}
