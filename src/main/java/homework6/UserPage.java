package homework6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserPage extends BaseView{
    public UserPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "entry-tatianasenichka-6706")
    private WebElement post6706;

    @FindBy(id = "entry-tatianasenichka-8190")
    private WebElement post8190;

    @FindBy(xpath = "//article[@class='entryunit entryunit--air entryunit--view-recent js-emojis ng-scope']")
    private List<WebElement> postsList;

    public OpenedPostPage openPost(String id){
        postsList.stream().filter(p -> p.getText().contains(id)).findFirst().get().click();
        return new OpenedPostPage(driver);
    }
}
