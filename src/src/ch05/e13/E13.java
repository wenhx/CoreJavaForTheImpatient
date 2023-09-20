package ch05.e13;

import java.util.Objects;
import java.util.logging.Logger;

public class E13 {
    public static void run() {
        Logger logger = Logger.getLogger("ch05.e13");
        logger.setFilter(record -> {
            Objects.requireNonNull(record);
            String message = record.getMessage();
            if (Objects.isNull(message) || message.isEmpty())
                return false;
            message = message.toLowerCase();
            if (message.contains("sex") || message.contains("drugs") || message.contains("c++"))
                return false;
            return true;
        });
        logger.info("Message 1");
        logger.info("Message 2 with sEx");
        logger.info("Message 3 with dRugs");
        logger.info("Message 4 with C++");
        logger.info("Message 5");
    }
}
