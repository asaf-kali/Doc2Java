package doc2java.main;

import java.util.logging.*;

public class Log {

	private static final String LOG_NAME = "doc2java";
	private static final String LOG_DIR = "logs/";
	private static Logger logger;

	private static boolean validateLogDir() {
		File logDir = new File("./" + LOG_DIR);
		if (!logDir.exists())
			return logDir.mkdir();
		return true;
	}

	private static void initLogger() {
		logger = Logger.getLogger(LOG_NAME);

		ConsoleHandler ch = new ConsoleHandler();
		ch.setLevel(Level.ALL);
		logger.addHandler(ch);

		if (!validateLogDir()) {
			logger.severe("Could not create log directory.");
			return;
		}
		Handler fh = new FileHandler();
		logger.addHandler();
	}

	public Log() {

	}
}
