package beens;


/**
 *
 * @author Adrian Ramos Colón
 */
public class Usuario {
    
    private String login;
    private String password;
    private String email;
    private String name;
    private String surname;
    
    
    /**
     * Constructor que setea los atributos
     * @param login
     * @param password
     * @param email
     * @param name
     * @param surname 
     */
    public Usuario(String login, String password, String email, String name, String surname){
        this.setLogin(login);
        this.setPassword(password);
        this.setEmail(email);
        this.setName(name);
        this.setSurname(surname);
    }

    /**
     * Constructor por defecto
     */
    public Usuario() {
    }

    /**
     * Constructor "Copia"
     * @param usr
     */
    public Usuario(Usuario usr){
        this.login=usr.getLogin();
        this.password = usr.getPassword();
        this.email = usr.getEmail();
        this.name = usr.getName();
        this.surname = usr.getSurname();
    }
   
    @Override
    public String toString() {
        return "login: " + login + ", password: " + password + 
                ", email: " + email + ", name: " + name + ", surname: " + surname ;
    }
    

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
            

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }
}
