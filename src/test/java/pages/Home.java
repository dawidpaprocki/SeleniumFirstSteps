package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static config.WebDriverSingleton.getInstance;
@Data
public class Home extends BasePage {

    public Home() {
        super();
    }

    @FindBy(linkText = "A/B Testing")
    private WebElement aBTesting;

    @FindBy(linkText = "Basic Auth")
    private WebElement basicAuth;

    @FindBy(linkText = "Broken Images")
    private WebElement brokenImages;

    @FindBy(linkText = "Challenging DOM")
    private WebElement challengingDOM;

    @FindBy(linkText = "Checkboxes")
    private WebElement checkBoxes;

    @FindBy(linkText = "Disappearing Elements")
    private WebElement disappearingElements;

    @FindBy(linkText = "Drag and Drop")
    private WebElement dragAndDrop;

    @FindBy(linkText = "Dropdown")
    private WebElement dropDown;

    @FindBy(linkText = "Dynamic Content")
    private WebElement dynamicContent;

    @FindBy(linkText = "Dynamic Controls")
    private WebElement dynamicControls;

    @FindBy(linkText = "Dynamic Loading")
    private WebElement dynamicLoading;

    @FindBy(linkText = "Exit Intent")
    private WebElement exitIntent;

    @FindBy(linkText = "File Download")
    private WebElement fileDownload;

    @FindBy(linkText = "File Upload")
    private WebElement fileUpload;

    @FindBy(linkText = "Floating Menu")
    private WebElement floatingMenu;

    @FindBy(linkText = "Forgot Password")
    private WebElement forgotPassword;

    @FindBy(linkText = "Form Authentication")
    private WebElement formAuthentication;

    @FindBy(linkText = "Frames")
    private WebElement frames;

    @FindBy(linkText = "Geolocation")
    private WebElement geolocation;

    @FindBy(linkText = "Horizontal Slider")
    private WebElement horizontalSlider;

    @FindBy(linkText = "Hovers")
    private WebElement hovers;

    @FindBy(linkText = "Infinite Scroll")
    private WebElement infiniteScroll;

    @FindBy(linkText = "JQuery UI Menus")
    private WebElement jQueryUIMenus;

    @FindBy(linkText = "JavaScript Alerts")
    private WebElement javaScriptAlerts;

    @FindBy(linkText = "JavaScript onload event error")
    private WebElement javaScriptOnloadEventError;

    @FindBy(linkText = "Key Presses")
    private WebElement keyPresses;

    @FindBy(linkText = "Large & Deep DOM")
    private WebElement largeAndDeepDOM;

    @FindBy(linkText = "Multiple Windows")
    private WebElement multipleWindows;

    @FindBy(linkText = "Nested Frames")
    private WebElement nestedFrames;

    @FindBy(linkText = "Notification Messages")
    private WebElement notificationMessages;

    @FindBy(linkText = "Redirect Link")
    private WebElement redirectLink;

    @FindBy(linkText = "Secure File Download")
    private WebElement secureFileDownload;

    @FindBy(linkText = "Shifting Content")
    private WebElement shiftingContent;

    @FindBy(linkText = "Slow Resources")
    private WebElement slowResources;

    @FindBy(linkText = "Sortable Data Tables")
    private WebElement sortableDataTables;

    @FindBy(linkText = "Status Codes")
    private WebElement statusCodes;

    @FindBy(linkText = "Typos")
    private WebElement typos;

    @FindBy(linkText = "WYSIWYG Editor")
    private WebElement wysiwygEditor;

    public void profileLogin(String password, String admin) {
            getInstance().get("http://"+password+":"+admin+"@the-internet.herokuapp.com/basic_auth");
        new BasicAuth();
    }
}

