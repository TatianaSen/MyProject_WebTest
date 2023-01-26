package homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class Authorization {

    private static Authorization authorization;

    private Authorization() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.livejournal.com/");

        //new WebDriverWait(driver, Duration.ofSeconds(10)).until( ExpectedConditions.urlContains("google"));
        WebElement enterButton = driver.findElement(By.cssSelector(".s-header-item__link--login"));
        enterButton.click();
        WebElement nameField = driver.findElement(By.id("user"));
        nameField.sendKeys("TatianaSenichka");
        WebElement loginField = driver.findElement(By.id("lj_loginwidget_password"));
        loginField.click();
        loginField.sendKeys("Z/x.c,vmbn2022");
        WebElement enterAction = driver.findElement(By.name("action:login"));
        enterAction.click();
        driver.quit();
    }

    public static Authorization getAuthorization(){
        if (authorization==null) authorization = new Authorization();
        return authorization;

    }
}
