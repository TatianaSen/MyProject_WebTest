package homework6;

import homework7.AdditionalLogger;
import homework7.JunitExtension;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.extension.TestWatcher;
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

    @Story(("Тестим LJ"))
   // @ExtendWith(JunitExtension.class)
public class BaseTest {
    WebDriver driver;
    MainPage mainPage;
    @RegisterExtension
    JunitExtension testWatcher =new JunitExtension();

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
