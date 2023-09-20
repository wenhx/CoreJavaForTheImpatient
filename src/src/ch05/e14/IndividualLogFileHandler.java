package ch05.e14;

import java.io.IOException;
import java.util.logging.*;

public class IndividualLogFileHandler extends Handler {
    @Override
    public void publish(LogRecord record) {
        try {
            String logFileName = System.currentTimeMillis() + ".html";
            FileHandler fileHandler = new FileHandler(logFileName);
            fileHandler.setFormatter(new Formatter() {
                @Override
                public String format(LogRecord record) {
                    return String.format("<html><head><title>Log</title></head><body>%s</body></html>", record.getMessage());
                }
            });
            fileHandler.publish(record);
            fileHandler.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void flush() {
    }

    @Override
    public void close() throws SecurityException {
    }
}