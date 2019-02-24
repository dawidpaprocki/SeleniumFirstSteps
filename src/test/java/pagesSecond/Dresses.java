package pagesSecond;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static config.WebDriverSingleton.getInstance;

@Data
public class Dresses extends BasePageSecond {

    @FindBy(xpath = "//img[@src='http://automationpractice.com/img/p/8/8-home_default.jpg']")
    private WebElement firstDress;

    @FindBy(xpath = "//a[@data-id-product='3']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//span[@title='Close window']")
    private WebElement close;

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    private WebElement choppingCart;

    private Actions actions;

    public Dresses() {
        super();
        actions = new Actions(getInstance());
    }

    public void addDressToCart() throws InterruptedException {
        actions.moveToElement(firstDress).perform();
        Thread.sleep(1000);
        addToCartButton.click();
        Thread.sleep(1000);
        close.click();
    }

    public boolean checkIfElementIsVisible(String whatToSearch) {
        actions.moveToElement(choppingCart).perform();
        try {
            getInstance().findElement(By.className(whatToSearch));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }
}
