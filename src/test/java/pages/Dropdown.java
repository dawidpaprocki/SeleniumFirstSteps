package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
public class Dropdown extends BasePage {

    @FindBy(id = "dropdown")
    private WebElement dropDownList;

    public Dropdown() {
        super();
    }

}
