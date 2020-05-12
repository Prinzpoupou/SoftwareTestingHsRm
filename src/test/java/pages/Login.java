package pages;

import com.codeborne.selenide.Condition;
import org.junit.Assert;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.*;


public class Login {

    private By uNameLoc = By.id("username");
    private By pWordLoc = By.id("password");
    private By loginButton = By.className("radius");
    private By successMsg = By.cssSelector(".flash.success");
    private By failedMsg = By.cssSelector(".flash.error");

    public Login(){
        open("http://the-internet.herokuapp.com/login");
    }

    public void with(String username, String password){
        $(uNameLoc).val(username);
        $(pWordLoc).val(password);
        $(loginButton).click();
    }

    public void assertValidLogin(){
        $(successMsg).shouldBe(visible);
        String url = getWebDriver().getCurrentUrl();
        Assert.assertEquals("http://the-internet.herokuapp.com/secure" , url);
    }

    public void assertInvalidLogin(){
        $(failedMsg).shouldBe(visible);
        String url = getWebDriver().getCurrentUrl();
        Assert.assertEquals("http://the-internet.herokuapp.com/login" , url);
    }

    public void wrongUName(){
        $(failedMsg).shouldHave(Condition.text("Your username is invalid!"));
    }

    public void wrongPassword(){
        $(failedMsg).shouldHave(Condition.text("Your password is invalid!"));
    }
}
