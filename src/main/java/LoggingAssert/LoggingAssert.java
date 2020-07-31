package LoggingAssert;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.Reporter;

public class LoggingAssert {

    //Makes console print messages in specific color.
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    //Method for assertion True Assertion testing and console log.
    public void executeAssert(boolean lassertAssertion) {
        try {
            Assert.assertTrue(lassertAssertion);
            Reporter.log(ANSI_GREEN + "Pass: Assertion is True." + ANSI_RESET, true);
        } catch (Exception e) {
            Reporter.log(ANSI_RED + "Fail: Assertion is False." + ANSI_RESET, false);
        }
    }
    }

class FalseAssert extends LoggingAssert {

    //Method for False Assertion testing and console log.
    @Override
    public void executeAssert(boolean lassertAssertion) {
        try {
            Assert.assertFalse(lassertAssertion);
            Reporter.log(ANSI_GREEN + "Pass: Assertion is False." + ANSI_RESET, true);
        } catch (Exception e) {
            Reporter.log(ANSI_RED + "Fail: Assertion is True." + ANSI_RESET, false);
        }
    }
}

class EqualsAssert extends LoggingAssert {

    //Method for assertEquals and console log.
    public void executeAssert(boolean lassertAssertion, boolean assertionEquals){
        try {
            Assert.assertEquals(lassertAssertion, assertionEquals);
            Reporter.log(ANSI_GREEN + "Pass: Assertion is equal." + ANSI_RESET, true);
        } catch (Exception e) {
            Reporter.log(ANSI_RED + "Fail: Assertion not equal." + ANSI_RESET, false);
        }
    }
}