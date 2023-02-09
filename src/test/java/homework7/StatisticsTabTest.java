package homework7;

import homework6.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.io.ByteArrayInputStream;

public class StatisticsTabTest {
    WebDriver driver;
    MainPage mainPage;

    @RegisterExtension
    JunitExtension testWatcher =new JunitExtension();

    @Story(("Статистика профиля на LJ"))

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
    }

    @BeforeEach
    void  getPage() {
        driver = new EventFiringDecorator(new AdditionalLogger()).decorate(new ChromeDriver());
        mainPage = new MainPage(driver);
        driver.get("https://www.livejournal.com/");
        // driver.get(System.getenv("BASE_URL"))
    }

    @Test
    @Feature("Статистика по Моим гостям")
//    @Issue("123")
//    @TmsLink("123")
    void statMyguestsTest(){
        mainPage.clickSignInButton()
                .login("TatianaSenichka", "Z/x.c,vmbn2022")
                .navigationBlock.hoverProfileMenuAndClickStat()
                .guestsTab();
        Assertions.assertTrue(driver.getCurrentUrl().contains("guests"));
    }

    @Test
    @Feature("Статистика по Записям")
    void statPostsTest(){
        mainPage.clickSignInButton()
                .login("TatianaSenichka", "Z/x.c,vmbn2022")
                .navigationBlock.hoverProfileMenuAndClickStat()
                .postsTab();
        Assertions.assertTrue(driver.getCurrentUrl().contains("post"));
    }

    @Test
    @Feature("Статистика по Комментариям")
    void statCommentsTest(){
        mainPage.clickSignInButton()
                .login("TatianaSenichka", "Z/x.c,vmbn2022")
                .navigationBlock.hoverProfileMenuAndClickStat()
                .commentsTab();
        Assertions.assertTrue(driver.getCurrentUrl().contains("comments"));
    }

    @Test
    @Feature("Статистика по Читателям")
    void statReadersTest(){
        mainPage.clickSignInButton()
                .login("TatianaSenichka", "Z/x.c,vmbn2022")
                .navigationBlock.hoverProfileMenuAndClickStat()
                .readersTab();
        Assertions.assertTrue(driver.getCurrentUrl().contains("rss"));
    }

    @Test
    @Feature("Статистика по Лайкам")
    void statLikesTest(){
        mainPage.clickSignInButton()
                .login("TatianaSenichka", "Z/x.c,vmbn2022")
                .navigationBlock.hoverProfileMenuAndClickStat()
                .likesTab();
        Assertions.assertTrue(driver.getCurrentUrl().contains("likes"));
    }

    @Test
    @Feature("Статистика по Социальному капиталу")
    void statCapitalTest(){
        mainPage.clickSignInButton()
                .login("TatianaSenichka", "Z/x.c,vmbn2022")
                .navigationBlock.hoverProfileMenuAndClickStat()
                .capitalTab();
        Assertions.assertTrue(driver.getCurrentUrl().contains("capital"));
    }



    @AfterEach
    void tearDown () {
        LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry log: logs){
            Allure.addAttachment("Элемент лога браузера", log.getMessage());
        }
        testWatcher.setScreenshot(new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
        driver.quit();
    }
}
