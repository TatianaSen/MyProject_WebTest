package homework6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class StatisticsPage extends BaseView{
    public StatisticsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[.='Мои гости']")
    private WebElement myGuestsStat;


    public StatisticsPage statTabs(){
        myGuestsStat.click();
        return this;
    }
}

