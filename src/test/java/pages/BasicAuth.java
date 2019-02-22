package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static config.WebDriverSingleton.getInstance;

public class BasicAuth extends BasePage {

    public BasicAuth() {
        super();
    }
    @FindBy(css = "h3")
    private WebElement h3Text;

    public BasicAuth(WebElement h3Text) {
        this.h3Text = h3Text;
    }

    public WebElement getH3Text() {
        return h3Text;
    }
}
