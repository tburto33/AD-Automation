package LoggingAssert;

import org.testng.asserts.Assertion;
import pageObjects.SearchPage;

import java.util.logging.ConsoleHandler;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggingAssert extends Assertion {

    //Creates new logger for assertions.
    Logger logger = Logger.getLogger(SearchPage.class.getName());

    //Handler for logger console.
    ConsoleHandler handler = new ConsoleHandler();

    //Manager for logger.
    LogManager manager = LogManager.getLogManager();

    public void executeAssert(){

    }


}
