package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static config.WebDriverSingleton.getInstance;


@Data
public class Hovers extends BasePage {

    @FindBy(xpath= "//img[@src='/img/avatar-blank.jpg']")
    private List<WebElement> imagesList;

    @FindBy(css = "h5")
    private List<WebElement> h5List;

    public Hovers() {
        super();
    }

    public boolean hoverElement(Integer whichLinkHover) {
        Actions actions = new Actions(getInstance());
        actions.moveToElement(imagesList.get(whichLinkHover)).perform();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return h5List.get(whichLinkHover).isDisplayed();
    }
}
