package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Data
public class BasicAuth extends BasePage {

    public BasicAuth() {
        super();
    }

    @FindBy(css = "h3")
    private WebElement h3Text;

}
