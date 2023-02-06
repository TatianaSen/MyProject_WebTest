package homework6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigationBlock extends BaseView {
    public NavigationBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(@class, 's-nav-item__name')]")
    private WebElement profileMenu;

    @FindBy(xpath = "//a[.='Статистика']")
    private WebElement statButton;

    public StatisticsPage hoverProfileMenuAndClickStat(){
        webDriverWait.until(ExpectedConditions.visibilityOf(profileMenu));
        actions.moveToElement(profileMenu)
                .perform();
       webDriverWait.until(ExpectedConditions.elementToBeClickable(statButton));
       statButton.click();
        return new StatisticsPage(driver);
    }

    public UserPage freshPosts(){
        webDriverWait.until(ExpectedConditions.visibilityOf(profileMenu));
        profileMenu.click();
        return new UserPage(driver);
    }

}
