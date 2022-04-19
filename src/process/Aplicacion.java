
package process;

import beens.Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import utilities.UtilES;

/**
 *
 * @author Adrian Ramos Colon
 */
public class Aplicacion {
    
  
    UtilES util = new UtilES();
    Usuario usr = null;
    ArrayList<Usuario> lista = new ArrayList<>();


    /**
     * Ejecucion principal del programa
     */
    public void ejecutar() {
        
        try {
            leerArchivo();
        } catch (IOException | NullPointerException io ) {
            io.getMessage();
        } catch (IllegalStateException ise){
            ise.getMessage();
        } catch (NoSuchElementException nee){
            nee.getMessage();
        }
    }

    /**
     * Inicia el proceso de lectura del archivo ya exixtente, lo tokemiza y crea objetos 
     * Usuario con los datos del archivo atributes.txt
     * @throws IOException
     * @throws NullPointerException
     */
    private void leerArchivo() throws IOException {
        boolean verificar = false;

        do {            
            /**
             * El archivo es "atributes.txt" y se encuentra en el directorio del proyecto
             */
            util.mensaje("Introduce la ruta del archivo"); 
            File file = new File(util.pideCadena());
            if (file.exists()) {
                verificar=true;
                util.mensaje("Archivo encontrado\n");
                tokemizado(file);
                mostrarUsuario();
            }else 
            util.mensaje("Archivo no encontrado");     
        } while (!verificar);
    }
    
    
    /**
     * Asigna los atributos del archivo a los objetos Usuario
     * @param strTK 
     */
    private void asignarAtributos(StringTokenizer strTK){
        int i = 0;
        usr = new Usuario();
        while (strTK.hasMoreElements()) {
            String str = strTK.nextToken(":");
            switch (i) {
                case 0 -> usr.setLogin(str);
                case 1 -> usr.setPassword(str);
                case 2 -> usr.setEmail(str);
                case 3 -> usr.setName(str);
                case 4 -> usr.setSurname(str);
            }
            i++; 
        }
    }
    
    
    /**
     * Imprime los usuraios ya validados 
     */
    private void mostrarUsuario(){
        for (Usuario usuario : lista) {
            util.mensaje(usuario.toString()); 
        }
    }
    
    /**
     * A partir del archivo, tokemiza su contenido separado por ":" crea Usuarios a partir del metodo 
     * asiganrAtributos() y los añade al contenedor si cumplen la validacion.·
     * @param file
     * @throws FileNotFoundException
     * @throws IOException 
     */
    private void tokemizado(File file) throws FileNotFoundException, IOException{
        FileReader freader = new FileReader(file);
        BufferedReader br = new BufferedReader(freader);
        String linea = br.readLine();
        
        while (linea != null) {
            StringTokenizer st = new StringTokenizer(linea, ":");
            asignarAtributos(st);
            Usuario usr2 = new Usuario(usr);
            if (compruebaDatos())
                lista.add(usr2);
            linea = br.readLine();
        }
    }
    
    /**
     * Comprueba si los datos cumplen con la validacion establecida.
     * La validación consiste en comprobar que cada dato tiene al menos 
     * 5 caracteres y que el email posee un '@'. Si no es válido alguno 
     * de los datos de la solicitud, se descarta.
     * @return boolean 
     */
    private boolean compruebaDatos(){
        boolean opc= false;
        if (!usr.getEmail().contains("@") || usr.getEmail().length()<5 || usr.getLogin().length()<5 ||
               usr.getName().length()<5 || usr.getPassword().length()<5 || usr.getSurname().length()<5){
            opc = false;
        }else{
             opc = true;
        }
        return opc;
    }
    
    
}
