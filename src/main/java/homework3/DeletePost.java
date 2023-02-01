package homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DeletePost {

    private static DeletePost deletePost;

    private DeletePost(){
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
        WebElement profileMenu = driver.findElement(By.cssSelector(".s-header-item--user"));
        profileMenu.click();
        try {
            driver.findElement(By.cssSelector(".s-header-sub-list-item__link--postlist")).click();
        } catch (ElementNotInteractableException e){
            System.out.println(e.getSupportUrl());
        }
        WebElement listPost = driver.findElement(By.xpath("//a[contains(@href, 'https://tatianasenichka.livejournal.com/7692.html')]"));
        listPost.click();
        WebElement managePost = driver.findElement(By.cssSelector(".svgicon--more"));
        managePost.click();
        WebElement editContent = driver.findElement(By.cssSelector(".root-0-2-148:nth-child(1) > .text-0-2-150"));
        editContent.click();
        WebElement deletePost = driver.findElement(By.cssSelector(".itemRed-0-2-257"));
        deletePost.click();
        WebElement confirmDelete = driver.findElement(By.cssSelector(".reset-0-2-89:nth-child(2) > .rootIn-0-2-98"));
        confirmDelete.click();
        driver.quit();
    }
    public static DeletePost getDeletePost(){
        if (deletePost==null) deletePost = new DeletePost();
        return deletePost;

    }
}
