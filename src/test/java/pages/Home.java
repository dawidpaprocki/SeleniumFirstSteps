package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

public class Home extends BasePage {

    public Home() {
        super();
    }

    @FindBy(tagName = "a")
    private List<WebElement> avaiableLinks;

    public Object abTestCheck() {
        Optional<WebElement> abTestFound = avaiableLinks.stream()
                .filter(webElement -> webElement.getText().equals("A/B Testing"))
                .findFirst();
        if (abTestFound.isPresent()) {
            abTestFound.get().click();
            return new AbTest();
        }
        return new Home();
    }
}

