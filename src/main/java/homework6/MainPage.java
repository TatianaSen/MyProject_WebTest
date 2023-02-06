package homework6;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BaseView {

    @FindBy(css = ".s-header-item__link--login")
    private WebElement signInButton;

    @FindBy(css = ".s-do-item-search-btn .svgicon")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='s-header-search__input-wrapper']")
    private WebElement seachField;


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public LogInPage clickSignInButton(){
        signInButton.click();
        return new LogInPage(driver);
    }

    public void searchFromMain(String text) throws InterruptedException {
        searchButton.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(seachField));
        seachField.sendKeys(text, Keys.ENTER);
        Thread.sleep(5000);
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
    }
}
