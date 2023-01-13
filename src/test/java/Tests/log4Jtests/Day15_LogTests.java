package Tests.log4Jtests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class Day15_LogTests {

    private static Logger logger = LogManager.getLogger(Day15_LogTests.class.getName());
    //call from org.apache.logging.log4j

    @Test
    public void test1(){
        logger.fatal("Fatal");
        logger.error("Error");
        logger.warn("Warning");
        logger.debug("Debug");
        logger.info("INFO");

    }
}
