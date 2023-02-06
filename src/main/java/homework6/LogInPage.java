package homework6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BaseView {

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user")
    private WebElement emailField;

    @FindBy(id = "lj_loginwidget_password")
    private WebElement passwordField;

    @FindBy(name = "action:login")
    private WebElement submitButton;

    public AuthorisedMainPage login(String login, String password){
        emailField.sendKeys(login);
        passwordField.sendKeys(password);
        submitButton.click();
        return new AuthorisedMainPage(driver);
    }
}
