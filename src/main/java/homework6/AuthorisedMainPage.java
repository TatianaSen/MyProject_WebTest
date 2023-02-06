package homework6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AuthorisedMainPage extends BaseView {
    public NavigationBlock navigationBlock;

    public AuthorisedMainPage(WebDriver driver){
        super(driver);
        navigationBlock = new NavigationBlock(driver);
    }

    @FindBy(css = ".s-header-item-post--long")
    private WebElement newPostButton;

    public NewPostPage toWright(){
        webDriverWait.until(ExpectedConditions.visibilityOf(newPostButton));
        newPostButton.click();
        return new NewPostPage(driver);
    }

}
