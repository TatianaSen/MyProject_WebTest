package homework5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractTest {
   static WebDriver driver;
    static WebDriverWait webDriverWait;
   static Actions actions;

    @BeforeAll
    static void registerDriver() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
    }

    @BeforeEach
    void  getPage() throws InterruptedException {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get("https://www.livejournal.com/");
        ((JavascriptExecutor) driver).executeScript("let element = document.evaluate(\"//article[@class='cookies-banner']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null)\n" +
                "element.singleNodeValue.remove()");
        Thread.sleep(5000);
        WebElement enterButton = driver.findElement(By.cssSelector(".s-header-item__link--login"));
        enterButton.click();
        WebElement nameField = driver.findElement(By.id("user"));
        nameField.sendKeys("TatianaSenichka");
        WebElement loginField = driver.findElement(By.id("lj_loginwidget_password"));
        loginField.click();
        loginField.sendKeys("Z/x.c,vmbn2022");
        WebElement enterAction = driver.findElement(By.name("action:login"));
        enterAction.click();

        Assertions.assertDoesNotThrow(() -> driver.navigate().to("https://www.livejournal.com/"),
                "Страница недоступна");
        }
    @AfterEach
        void tearDown () {
          //  driver.quit();
        }
//        public static WebDriver getDriver() {
//            return driver;
//        }

    }
