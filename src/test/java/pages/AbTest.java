package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AbTest extends BasePage {

    @FindBy(css = "h3")
    private WebElement h3Text;
    @FindBy(css = "p")
    private WebElement pText;


    public AbTest() {
        super();
    }

    public WebElement getH3Text() {
        return h3Text;
    }

    public WebElement getPText() {
        return pText;
    }
}
