package LoggingAssert;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.Reporter;

public class LoggingAssert {

    //Makes console print messages in ANSI assigned color.
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";

    //Enums for assertion testing
    public enum AssertTest {
        ASSERT_TRUE,
        ASSERT_FALSE,
        ASSERT_EQUALS;
    }

    //Method for assertion True Assertion testing and console log.

    public void executeAssert(boolean lassertAssertion, AssertTest assertType) {
        switch(assertType){
            case ASSERT_TRUE:
                try{
                    Assert.assertTrue(lassertAssertion);
                    Reporter.log(GREEN + "Pass: Assertion is True." + RESET);
                }catch(Exception e) {
                    Reporter.log(RED + "Fail: Assertion is False." + RESET);
                    break;
                }
            case ASSERT_FALSE:
                try{
                    Assert.assertFalse(lassertAssertion);
                    Reporter.log(GREEN + "Pass: Assertion is False." + RESET);
                }catch(Exception e){
                    Reporter.log(RED + "Fail: Assertion is True." + RESET);
                    break;
                }
        }
    }

}