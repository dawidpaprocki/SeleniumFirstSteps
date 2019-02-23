package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

import static config.WebDriverSingleton.getInstance;

@Data
public class Download extends BasePage {

    @FindBy(linkText = "upload.jpeg")
    private WebElement uploadFileJpeg;
    @FindBy(linkText = "some-file.txt")
    private WebElement someFileText;


    public Download() {
        super();
    }

    public void moveToLink(WebElement linkName){
        Actions actions = new Actions(getInstance());
        actions.moveToElement(linkName).click().perform();
    }
    public Boolean checkIfDownloaded(WebElement linkName){
        File fileToCheck = new File("C:\\Users\\srel2\\Downloads\\"+linkName.getText());
        return fileToCheck.exists();
    }
}
