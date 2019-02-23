package tests;

import config.TestConfig;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.*;

import java.util.List;

import static org.junit.Assert.*;

public class Tests extends TestConfig {
    private Home home;

    @Before
    public void Before() {
        home = new Home();
    }

    @Test
    public void TestAbTestText() {
        //given
        home.getABTesting().click();
        AbTest abTest = new AbTest();
        //when
        String textFromH3ForTest = abTest.getH3Text().getText();
        String textFromPForTest = abTest.getPText().getText();
        //then
        assertTrue(textFromH3ForTest.equals("A/B Test Variation 1") ||
                textFromH3ForTest.equals("A/B Test Control"));
        assertEquals(textFromPForTest, "Also known as split testing. This is a way in which businesses are able to simultaneously test and learn different" +
                " versions of a page to see which text and/or functionality works best towards a desired outcome (e.g. a user action such as a click-through).");
    }

    @Test
    public void TestBasicAuth() {
        //given
        BasicAuth basicAuth = new BasicAuth();
        home.profileLogin("admin", "admin");
        //when
        String textFromH3ForTest = basicAuth.getH3Text().getText();
        //then
        assertEquals(textFromH3ForTest, "Basic Auth");
    }

    @Test
    public void TestBrokenImagesCheck() {
        //given
        home.getBrokenImages().click();
        BrokenImages brokenImages = new BrokenImages();
        //then
        assertFalse(brokenImages.checkIfNotBroken(brokenImages.getAsdf()));
        assertFalse(brokenImages.checkIfNotBroken(brokenImages.getHjkl()));
        assertTrue(brokenImages.checkIfNotBroken(brokenImages.getAvatar()));
    }

    @Test
    public void TestIfLastCheckBoxIsCheck() {
        //given
        home.getCheckBoxes().click();
        Checkboxes checkboxes = new Checkboxes();
        List<WebElement> checkBox = checkboxes.getCheckBox();
        //when
        WebElement webElementChecked = checkBox.get(checkBox.size() - 1);
        //then
        assertTrue(webElementChecked.isSelected());
    }

    @Test
    public void TestDropDownOptionCheck() {
        //given
        home.getDropDown().click();
        Dropdown dropdown = new Dropdown();
        Select selectList = new Select(dropdown.getDropDownList());
        //when
        selectList.selectByVisibleText("Option 2");
        //then
        assertEquals("Option 2", selectList.getFirstSelectedOption().getText());
    }

    @Test
    public void TestExitIntentTopPopOut() throws InterruptedException {
        //given
        home.getExitIntent().click();
        ExitIntent exitIntent = new ExitIntent();
        //when
        Thread.sleep(1000);
        exitIntent.mouseMove(0,-300);
        Thread.sleep(2000);
        //then
        assertTrue(exitIntent.getOuiBounceModal().isDisplayed());
    }

    @Test
    public void TestHoverCheckingH5TextIsVisible(){
        //given
        home.getHovers().click();
        Hovers hovers = new Hovers();
        //then
        assertTrue(hovers.hoverElement(0));
        assertFalse(hovers.hoverElement(1));
    }


    @Test
    public void TestDownloadIsFileDownloadedTrue() throws InterruptedException {
        //given
        home.getFileDownload().click();
        Download download = new Download();
        //when
        Thread.sleep(1000);
        download.moveToLink(download.getUploadFileJpeg());
        Thread.sleep(3000);
        //then
        assertTrue(download.checkIfDownloaded(download.getUploadFileJpeg()));
    }

    @Test
    public void TestDownloadIsFileDownloadedFalse() throws InterruptedException {
        //given
        home.getFileDownload().click();
        Download download = new Download();
        //when
        Thread.sleep(1000);
        download.moveToLink(download.getSomeFileText());
        Thread.sleep(3000);
        //then
        assertFalse(download.checkIfDownloaded(download.getUploadFileJpeg()));
    }

}
