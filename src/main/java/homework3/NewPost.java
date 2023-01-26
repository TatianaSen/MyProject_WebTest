package homework3;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewPost {

    private static NewPost newPost;

    private NewPost(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.livejournal.com/");

        WebElement enterButton = driver.findElement(By.cssSelector(".s-header-item__link--login"));
        enterButton.click();
        WebElement nameField = driver.findElement(By.id("user"));
        nameField.sendKeys("TatianaSenichka");
        WebElement loginField = driver.findElement(By.id("lj_loginwidget_password"));
        loginField.click();
        loginField.sendKeys("Z/x.c,vmbn2022");
        WebElement enterAction = driver.findElement(By.name("action:login"));
        enterAction.click();
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".s-header-item-post--long")));
        try {
            WebElement newPost = driver.findElement(By.cssSelector(".s-header-item-post--long"));
            newPost.click();
        }
        catch (org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebElement newPost = driver.findElement(By.cssSelector(".s-header-item-post--long"));
            newPost.click();
        }
        WebElement textField = driver.findElement(By.cssSelector(".public-DraftStyleDefault-block"));
        textField.sendKeys("Всем привет");
        WebElement postSettings = driver.findElement(By.xpath("//div[2]/button/span"));
        postSettings.click();
        WebElement createPost = driver.findElement(By.xpath("//footer/div/button/span"));
        createPost.click();

        driver.quit();
    }

    public static NewPost getNewPost(){
        if (newPost==null) newPost = new NewPost();
        return newPost;

    }
}
