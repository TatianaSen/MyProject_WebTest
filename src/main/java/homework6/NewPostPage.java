package homework6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewPostPage extends BaseView{
    public NewPostPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".public-DraftStyleDefault-block")
    private WebElement enterTextField;

    @FindBy(xpath = "//div[2]/button/span")
    private WebElement manageAndPublishButton;

    @FindBy(xpath = "//footer/div/button/span")
    private WebElement confirmPublishButton;
    @Step("Новый пост")
    public NewPostPage newPost(String text){
        enterTextField.sendKeys(text);
        manageAndPublishButton.click();
        confirmPublishButton.click();
        return this;
    }
}
