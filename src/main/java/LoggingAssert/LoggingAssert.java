package LoggingAssert;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.Reporter;

public class LoggingAssert {

    //Makes console print messages in specific color.
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    //Method for assertion testing and console log.
    public void executeAssert(boolean lassertAssertion) {

    }

public static class TrueAssert extends LoggingAssert {

    //Method for True Assertion testing and console log.
    @Override
    public void executeAssert(boolean lassertAssertion) {
        try {
            Assert.assertTrue(lassertAssertion);
            Reporter.log(ANSI_GREEN + "Assertion Pass" + ANSI_RESET, true);
        } catch (Exception e) {
            Reporter.log(ANSI_RED + "Assertion Fail" + ANSI_RESET, false);
        }
    }
}
}