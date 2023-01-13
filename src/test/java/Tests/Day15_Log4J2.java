package Tests;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;


public class Day15_Log4J2 {

    /*
    log means print or document, it is advanced form by System.out.println().   to log-->to print
    log4j2-->latest version
    level--> debug, info, error, fatal

    Advantage for Log4j : We use it for printing information on the console or file. We can print detailt report, with time, with message,
    then can sva the print on a file.

    Log4J is an API to log information in the console OR in a file

    Log4J is used to log the errors, infos, or debugs.
    This is similar to printing, but we can customize our logs with log4J

    Why log4J?
    1-With log4J we can log some or all of the below logs
    //we can say, if there is a debug just show me that debug.
        Fatal logs
        Error logs
        Informational logs
        Debug logs
    2-Log with time stamp
    3-Log in a console or in a file
        See the log history in a file
     */

/*

    2. Create a class : Day_Log4j
    3. Create Logger object:
        private static Logger logger = LogManager.getLogger(Demo1.class.getName());
    4. User logger object to add info
                     logger.debug("This is debug logger");
            logger.info("This is info logger");
            logger.error("This is error logger");
            logger.fatal("This is fatal logger");
    5. Check the console for logs. By default logger logs error or fatal        */



    //Create Logger object:
    private static Logger logger = LogManager.getLogger(Day15_Log4J2.class.getName());
    //Logger-->choose from -->org.apache.logging.log4j
    //select LogManager from org.apache.logging.log4j


    @Test
    public void log4JTest() {

        //User logger object to log/print information
        logger.fatal("Fatal log !!!");
        logger.error("Error Log !!!");
        logger.warn("Warning Log !!!");
        logger.debug("Debug Log !!!");
        logger.info("Info Log !!!");

        //Check the console for logs. By default logger logs error or fatal


        //a. Change the LEVEL to trace to see ALL LOGS
        //b. Log the information on a file
        //c. Do all there for the tests package ONLY

        //Standart Level : off-fatal-error-warn-info-debug-trace-all   -->resources-->log4j2.xml-->choose the level


    }


}