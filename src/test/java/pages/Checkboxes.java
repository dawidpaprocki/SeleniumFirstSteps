package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Data
public class Checkboxes extends BasePage {

    @FindBy(css = "input[type='checkbox']")
    private List<WebElement> checkBox;

    public Checkboxes() {
        super();
    }


}
