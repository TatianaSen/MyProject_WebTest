package homework5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LiveJournalTest extends AbstractTest {

    public static Logger logger = LoggerFactory.getLogger(LiveJournalTest.class);

    @Test
    void NewPost() throws InterruptedException {

        driver.findElement(By.cssSelector(".s-header-item-post--long")).click();
        driver.findElement(By.cssSelector(".public-DraftStyleDefault-block")).sendKeys("Всем привет");
        driver.findElement(By.xpath("//div[2]/button/span")).click();
        driver.findElement(By.xpath("//footer/div/button/span")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("tatianasenichka"));
        logger.info("Создание новой записи");
    }



    @Test
    void EditPost() throws InterruptedException{
       driver.findElement(By.cssSelector(".s-header-item--user")).click();
        try {
            driver.findElement(By.cssSelector(".s-header-sub-list-item__link--postlist")).click();
        } catch (ElementNotInteractableException e){
            System.out.println(e.getSupportUrl());
        }
        driver.findElement(By.id("entry-tatianasenichka-6706")).click();
        driver.findElement(By.cssSelector(".svgicon--more")).click();
        driver.findElement(By.cssSelector(".root-0-2-148:nth-child(1) > .text-0-2-150")).click();
        driver.findElement(By.cssSelector(".public-DraftStyleDefault-block")).sendKeys("Всем пока");
        driver.findElement(By.cssSelector(".backgroundBlue-0-2-104 > .rootIn-0-2-98")).click();
        driver.findElement(By.cssSelector(".rootMaxWidth-0-2-99")).click();
        Assertions.assertFalse(driver.getCurrentUrl().contains("draft"));
        logger.info("Редактирование записи");
    }

    @Test
    void DeletePost() throws InterruptedException{
       driver.findElement(By.cssSelector(".s-header-item--user")).click();
        try {
            driver.findElement(By.cssSelector(".s-header-sub-list-item__link--postlist")).click();
        } catch (ElementNotInteractableException e){
            System.out.println(e.getSupportUrl());
        }
        driver.findElement(By.id("entry-tatianasenichka-8229")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".svgicon--more")));
        WebElement post = driver.findElement(By.cssSelector(".svgicon--more"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", post);
        driver.findElement(By.cssSelector(".root-0-2-148:nth-child(1) > .text-0-2-150")).click();
        driver.findElement(By.cssSelector(".itemRed-0-2-257")).click();
        driver.findElement(By.cssSelector(".reset-0-2-89:nth-child(2) > .rootIn-0-2-98")).click();
        Assertions.assertFalse(driver.getCurrentUrl().contains("draft"));
        logger.info("Удаление записи");
    }
    @Test
    void Search() throws InterruptedException{
       driver.findElement(By.cssSelector(".s-do-item-search-btn .svgicon")).click();
       driver.findElement(By.xpath("(//input[@id='SearchText'])[2]")).sendKeys("рецепты", Keys.ENTER);
        Thread.sleep(5000);
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        String urlPress = "https://www.livejournal.com/rsearch?q=%D1%80%D0%B5%D1%86%D0%B5%D0%BF%D1%82%D1%8B&sort=_score&searchArea=post";
        Assertions.assertEquals(urlPress, driver.getCurrentUrl());
        logger.info("Поиск по ключевому слову в новом окне");

    }
    @Test
    void myGuests() throws InterruptedException{
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".s-header-sub-list-item__link--profile")));
        actions.moveToElement(driver.findElement(By.cssSelector(".s-header-sub-list-item__link--profile")))
                .perform();
        driver.findElement(By.xpath("//a[.='Статистика']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Мои гости')]")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("guests"));
        logger.info("Просмотр статистики по гостям");

    }
}
