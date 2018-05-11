package doc2java.main;

import java.io.IOException;
import java.util.logging.*;

class Log {

	private static Logger logger;
	private static final String LOG_NAME = "doc2java";
	private static final String LOG_DIR = "logs/";
	private static final String LOG_EXT = ".log";
	private static final Level CONSOLE_LEVEL = Level.ALL;
	private static final Level FILE_LEVEL = Level.ALL;

	private static boolean validateLogDir() {
		File logDir = new File("./" + LOG_DIR);
		if (!logDir.exists())
			return logDir.mkdir();
		return true;
	}

	private static String getLogName() {
		String dateStr = Utils.nowString(DateFormat.FileName);
		return LOG_DIR + dateStr + LOG_EXT;
	}

	static void initLogger() {
		logger = Logger.getLogger(LOG_NAME);
		logger.setUseParentHandlers(false); // Avoid double printing

		// Console Handler
		ConsoleHandler ch = new ConsoleHandler();
		ch.setFormatter(new ConsoleFormatter());
		ch.setLevel(CONSOLE_LEVEL);
		logger.addHandler(ch);

		// File Handler
		if (!validateLogDir()) {
			warning("Could not create log directory");
			return;
		}
		try {
			String fileName = getLogName();
			Handler fh = new FileHandler(fileName);
			fh.setLevel(FILE_LEVEL);
			logger.addHandler(fh);
			finer("Log file " + prm(fileName) + " created successfully");
		} catch (IOException e) {
			warning("Failed to create FileHandler to logger: " + e.getMessage());
		}
		System.out.println();
	}

	/* --- Logging facade --- */

	static void info(String msg) {
		log(Level.INFO, msg);
	}

	static void warning(String msg) {
		log(Level.WARNING, msg);
	}

	static void severe(String msg) {
		log(Level.SEVERE, msg);
	}

	static void fine(String msg) {
		log(Level.FINE, msg);
	}

	static void finer(String msg) {
		log(Level.FINER, msg);
	}

	static void finest(String msg) {
		log(Level.FINEST, msg);
	}

	static void log(Level level, String msg) {
		logger.log(level, msg);
	}

	static String prm(Object obj) {
		return "[" + obj + "]";
	}

	private static class ConsoleFormatter extends Formatter {
		@Override
		public String format(LogRecord record) {
			StringBuilder builder = new StringBuilder();
			builder.append(prm(Utils.nowString(DateFormat.Log)));
			builder.append(" - ");
			builder.append(prm(record.getLevel()));
			builder.append(" - ");
			builder.append(record.getMessage());
			builder.append("\n");
			return builder.toString();
		}
	}
}
