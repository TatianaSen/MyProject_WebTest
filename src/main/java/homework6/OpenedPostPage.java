package homework6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OpenedPostPage extends BaseView{
    public OpenedPostPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".svgicon--more")
    private WebElement postMenuButton;

    @FindBy(css = ".root-0-2-148:nth-child(1) > .text-0-2-150")
    private WebElement editPostButton;

    @FindBy(css = ".public-DraftStyleDefault-block")
    private WebElement enterTextField;

    @FindBy(xpath = "//div[2]/button/span")
    private WebElement manageAndPublishButton;

    @FindBy(xpath = "//footer/div/button/span")
    private WebElement confirmPublishButton;

    @FindBy(css = ".itemRed-0-2-257")
    private WebElement deletePostButton;

    @FindBy(css = ".reset-0-2-89:nth-child(2) > .rootIn-0-2-98")
    private WebElement confirmDeleteButton;


    @Step("Редактировать пост")
    public void editPost(String addtext){
        webDriverWait.until(ExpectedConditions.visibilityOf(postMenuButton));
        postMenuButton.click();
        editPostButton.click();
        enterTextField.sendKeys(addtext);
        manageAndPublishButton.click();
        confirmPublishButton.click();
    }
    @Step("Удалить пост")
    public void deletePost(){
        webDriverWait.until(ExpectedConditions.visibilityOf(postMenuButton));
        postMenuButton.click();
        editPostButton.click();
        deletePostButton.click();
        confirmDeleteButton.click();
    }
}
