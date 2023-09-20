package ch05.e14;

import java.util.logging.Logger;

public class E14 {
    public static void run() {
        Logger logger = Logger.getLogger("");
        logger.setUseParentHandlers(false); // Disable default console handler

        IndividualLogFileHandler fileHandler = new IndividualLogFileHandler();
        logger.addHandler(fileHandler);

        // Log some messages
        logger.info("This is the first log message.");
        logger.info("This is the second log message.");

        // Close the file handler when done
        fileHandler.close();
    }
}