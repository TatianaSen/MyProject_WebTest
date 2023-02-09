package homework6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class StatisticsPage extends BaseView{
    public StatisticsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[.='Мои гости']")
    private WebElement myGuestsStat;

    @FindBy(xpath = "//a[.='Записи']")
    private WebElement postsStat;

    @FindBy(xpath = "//a[.='Комментарии']")
    private WebElement commentsStat;

    @FindBy(xpath = "//a[.='Читатели RSS']")
    private WebElement readersStat;

    @FindBy(xpath = "//a[.='Понравилось']")
    private WebElement likesStat;

    @FindBy(xpath = "//a[.='Социальный капитал']")
    private  WebElement capitalStat;

    @Step("Переход во вкладку Мои гости")
    public StatisticsPage guestsTab(){
        myGuestsStat.click();
        return this;
    }
    @Step("Переход во вкладку Записи")
    public StatisticsPage postsTab(){
        postsStat.click();
        return this;
    }
    @Step("Переход во вкладку Комментарии")
    public StatisticsPage commentsTab(){
        commentsStat.click();
        return this;
    }
    @Step("Переход во вкладку Читатели")
    public StatisticsPage readersTab(){
        readersStat.click();
        return this;
    }
    @Step("Переход во вкладку Понравилось")
    public StatisticsPage likesTab(){
        likesStat.click();
        return this;
    }
    @Step("Переход во вкладку Социальный капитал")
    public StatisticsPage capitalTab(){
        capitalStat.click();
        return this;
    }
}

