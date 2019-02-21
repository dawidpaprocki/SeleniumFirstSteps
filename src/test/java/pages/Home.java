package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.Optional;

import static config.WebDriverSingleton.getInstance;

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
    public BasicAuth profileLogin(String password, String admin) {
        Alert alert = getInstance().switchTo().alert();
        alert.sendKeys(admin + Keys.TAB + password);

        return new BasicAuth();
    }
}

