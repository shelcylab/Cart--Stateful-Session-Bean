/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateful;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author n01316980
 */
@Local
public interface CartBeanLocal {
     public void initialize(String person) throws BookException;
   
    public void initialize(String person, String id) throws BookException;
   
    public void addBook(String title);
   
    public void removeBook(String title) throws BookException;
   
    public List<String> getContents();
   
    public void remove(); 
}
