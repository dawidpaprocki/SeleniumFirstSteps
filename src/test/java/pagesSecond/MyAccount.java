package pagesSecond;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
public class MyAccount extends BasePageSecond {

    @FindBy(className = "page-heading")
    private WebElement pageHeading;

    public MyAccount() {
        super();
    }
}
