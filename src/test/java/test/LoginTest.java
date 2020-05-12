package test;

import org.junit.Test;
import pages.Login;
import org.junit.Before;

public class LoginTest {

    Login login;

    @Before
    public void setup(){
        login = new Login();
    }

    @Test
    public void LoginWithCorrectValues(){
        login.with("tomsmith", "SuperSecretPassword!");
        login.assertValidLogin();
    }

    @Test
    public void LoginWithWrongValues(){
        login.with("tomsmithqwqw", "Superord!");
        login.assertInvalidLogin();
    }

    @Test
    public void LoginWithWrongUsername(){
        login.with("tomsmithqwqw", "SuperSecretPassword!!");
        login.assertInvalidLogin();
        login.wrongUName();
        login.with("", "SuperSecretPassword!!");
        login.assertInvalidLogin();
        login.wrongUName();
    }

    @Test
    public void LoginWithWrongPassword(){
        login.with("tomsmith", "Supeword!!");
        login.assertInvalidLogin();
        login.wrongPassword();
        login.with("tomsmith", "");
        login.assertInvalidLogin();
        login.wrongPassword();
    }
}
