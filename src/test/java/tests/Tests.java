package tests;

import config.TestConfig;
import org.junit.Test;
import pages.AbTest;
import pages.BasicAuth;
import pages.Home;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Tests extends TestConfig {

    @Test
    public void testAbTestText() {
        Home home = new Home();

        AbTest abTest = (AbTest) home.abTestCheck();
        assertEquals("AbTest", abTest.getClass().getSimpleName());

        assertTrue(abTest.getH3Text().getText().equals("A/B Test Variation 1") ||
                abTest.getH3Text().getText().equals("A/B Test Control"));
        assertEquals(abTest.getPText().getText(),"Also known as split testing. This is a way in which businesses are able to simultaneously test and learn different" +
                " versions of a page to see which text and/or functionality works best towards a desired outcome (e.g. a user action such as a click-through).");
    }
}
