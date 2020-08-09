package Utilities;

import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;

public class LoggingAssert extends Assertion {
    @Override
    public void executeAssert(IAssert iAssert) {
        try {
            iAssert.doAssert();
            printColoredMessage(Color.GREEN, "PASSED - " + iAssert.getMessage());
        } catch (AssertionError assertionError) {
            printColoredMessage(Color.RED, "FAILED - " + iAssert.getMessage());
            printColoredMessage(Color.RED, assertionError.toString());
        }
    }

    private void printColoredMessage(Color color, String message) {
        System.out.println(color + message + Color.RESET);
    }

    private enum Color {
        RESET("\033[0m"),
        RED("\u001B[31m"),
        GREEN("\u001B[32m");

        private final String value;

        Color(final String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
}
