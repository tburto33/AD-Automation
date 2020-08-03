package LoggingAssert;
import org.testng.Assert;
import org.testng.Reporter;

public class LoggingAssert {

    //Makes console print messages in ANSI assigned color.
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";

    public void executeAssert(boolean lassertAssertion, String methodName) {

    }

public static class TrueAssert extends LoggingAssert {

    //Method for testing true assertions with console log of pass/fail.
    @Override
    public void executeAssert(boolean lassertAssertion, String methodName){
        try{
            Assert.assertTrue(lassertAssertion);
            Reporter.log(GREEN + "Pass: " + methodName + RESET, true);
        }catch (Exception e){
            Reporter.log(RED + "Fail: " + methodName + RESET, false);
        }
    }
}
}