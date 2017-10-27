package lab_1.ex_4.login;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Szymon
 */
public class Login {
    private String login;
    private String password;

    /**
     *
     * @param _login login jaki dana instancja klasy b?diz eprzechowywa?
     * @param _password has?o jakie dana instancja klasy b?diz eprzechowywa?
     */
    public Login(String _login, String _password){
        login = _login;
        password = _password;
    }

    /**
     *
     * @param _login login do por?wnania z przechowywanym wewn?trz obiektu
     * @param _password has?o do por?wnania z przechowywanym wewnatrz obiektu
     * @return prawda, gdy login i has?o zgadzaja sie, fa?sz gdy albo login albo has?o nie pasuje do tych rpzechowywanych przez instancj? kalsy
     */
    public boolean check(String _login, String _password){
        return (login.equals(_login) && password.equals(_password));
    }

}
