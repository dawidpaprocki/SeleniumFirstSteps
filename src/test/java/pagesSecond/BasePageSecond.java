package pagesSecond;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static config.WebDriverSingleton.getInstance;
import static utility.Actions.waitForVisibilityOfElement;

public class BasePageSecond {
    @FindBy(id = "header")
    private WebElement pageContent;

    public BasePageSecond() {
        PageFactory.initElements(getInstance(), this);
        waitForVisibilityOfElement(pageContent);
    }
}
