package utilities;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Adrian Ramos Colon
 */
public class UtilES {
    

    public String pideCadena(){
        String str="";
        try {
            Scanner sc = new Scanner(System.in);
            str= sc.nextLine();
        } catch (NoSuchElementException nse) {
            throw new NoSuchElementException ("ERROR: No se encontró ninguna liena");  
        } catch (IllegalStateException ie){
            throw new IllegalStateException ("ERROR: El escaner está cerrado");  
        }
        return str;
    }
    
    public void mensaje(String mensaje){
        System.out.println(mensaje);
    } 
    
}
