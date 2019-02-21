package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import ru.yandex.qatools.allure.annotations.Step;

import static config.WebDriverSingleton.getInstance;

public class BasicAuth extends BasePage {

    public BasicAuth() {
        super();
    }

    @Step
    public void profileLogin(String password, String admin) {
        Alert alert = getInstance().switchTo().alert();
        alert.sendKeys(admin + Keys.TAB + password);
    }
}
