package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static config.WebDriverSingleton.getInstance;


@Data
public class ExitIntent extends BasePage {
    @FindBy(css = "h3")
    private WebElement h3Text;
    @FindBy(id = "ouibounce-modal")
    private WebElement ouiBounceModal;

    public ExitIntent() {
        super();
    }

    public void mouseMove(Integer xOffset, Integer yOffset){
        Actions actions = new Actions(getInstance());

        actions.moveToElement(h3Text).moveByOffset(xOffset,yOffset).perform();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
