package server;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.*;


public class StartServer {

  static final Logger logger = Logger.getLogger(StartServer.class.getName());

    public static void main(String[] args) throws SQLException, IOException {
         new Main();

        logger.setLevel(Level.ALL);
        logger.getHandlers()[0].setLevel(Level.ALL);
        logger.getHandlers()[0].setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getLevel() + "\t" + record.getMessage() + "\t" +record.getMillis() + "\n";
            }
        });

        Handler handler = new FileHandler("logfile.log", true);
        System.out.println("как дела?");
        handler.setLevel(Level.ALL);
        handler.setFormatter(new SimpleFormatter());
        logger.addHandler(handler);

        logger.log(Level.INFO, "привет");

    }

}
