package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Data
public class DynamicControls extends BasePage{

    @FindBy(css = "input[type='checkbox']")
    private WebElement checkBox;
    @FindBy(css = "button[type='button']")
    private List<WebElement> listOFButton;
    @FindBy(id = "loading")
    private WebElement loadingBar;
    @FindBy(id = "message")
    private WebElement message;

    public DynamicControls() {
        super();
    }
    public Boolean visibilityOfLoadingBar(){
       String style = loadingBar.getCssValue("style");
        return style.equals("");
    }
    public WebElement getButton(String button){
        Optional<WebElement> webElement1 = listOFButton.stream().findFirst().filter(webElement -> webElement.getText().equals(button));
        return webElement1.get();
    }

    public Boolean checkIfElementIsPresent(WebElement webElement){
        try{
            webElement.getText();
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
