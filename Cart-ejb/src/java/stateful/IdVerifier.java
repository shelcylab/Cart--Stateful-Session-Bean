/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateful;

/**
 *
 * @author n01316980
 */
class IdVerifier {
    
    public IdVerifier() {
    }
   
    public boolean validate(String id)
    {
        boolean result = true;
       
        for(int i=0; i< id.length();i++) {
            if(Character.isDigit(id.charAt(i))==false)
            {
                result = false;
            }
        }
        return result;
    }
}
