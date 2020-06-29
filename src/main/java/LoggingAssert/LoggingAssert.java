package LoggingAssert;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;
import pageObjects.SearchPage;

import java.awt.*;

public class LoggingAssert {


    //Makes console print messages in color.
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public LoggingAssert() throws AWTException {
    }

    SoftAssert softAssert = new SoftAssert();


    //Runs assertion for passed in argument and prints results to console.
    public void executeAssert(boolean lassertAssertion) {

        try {
            softAssert.assertTrue(lassertAssertion,ANSI_GREEN + "Assertion " + lassertAssertion +  " has passed." + ANSI_RESET);
            //Reporter.log(ANSI_GREEN + "Assertion has passed." + ANSI_RESET);
        } catch (Exception e) {
            softAssert.assertFalse(lassertAssertion,ANSI_RED + "Assertion " + lassertAssertion + " has failed or is invalid." + ANSI_RESET);
            //Reporter.log(ANSI_RED + "Assertion has failed or is invalid." + ANSI_RESET);
        }
    }
}
