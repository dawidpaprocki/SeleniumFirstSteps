package pages;

import io.restassured.RestAssured;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;
import static config.WebDriverSingleton.getInstance;
@Data
public class BrokenImages  extends BasePage  {

    @FindBy(xpath= "//img[@src='asdf.jpg']")
    private WebElement asdf;

    @FindBy(xpath= "//img[@src='hjkl.jpg']")
    private WebElement hjkl;

    @FindBy(xpath= "//img[@src='img/avatar-blank.jpg']")
    private WebElement avatar;

    public BrokenImages() {
       super();
    }

    public Boolean checkIfNotBroken(WebElement webElement){
        String src = webElement.getAttribute("src");
        return RestAssured.get(src).statusCode() == 200;
    }
}
