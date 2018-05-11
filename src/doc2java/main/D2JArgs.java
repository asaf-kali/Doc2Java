package doc2java.main;

import org.apache.commons.io.FilenameUtils;
import sun.plugin2.gluegen.runtime.CPU;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

class D2JArgs {

	private static final int FIRST = 0;
	private static final int SECOND = 1;

	List<File> paths;
	File outDir;
	final boolean parseSuccess;

	D2JArgs(String[] args) {
		paths = new LinkedList<>();
		parseSuccess = parseArgs(args);
	}

	private boolean parseArgs(String[] args) {
		if (args == null)
			return false;
		int length = args.length;
		if (length < Constants.MIN_ARGS)
			return false;
		// Single argument case
		if (length == Constants.MIN_ARGS) {
			File srcDir = new File(args[FIRST]);
			if (!extractHtmlFiles(srcDir))
				return false;
			outDir = new File(srcDir, Constants.DEFAULT_OUT_DIR);
			if (outDir.exists()) {
				// TODO: Log write into existing directory
			} else {
				// TODO: Log mkdir
				if (!outDir.mkdir()) {
					System.out.println(Messages.MKDIR_FAIL + outDir.getAbsolutePath());
					return false;
				}
			}
			return true;
		}
		// Two arguments case
		if (length == Constants.TWO_ARGS) {
			File srcDir = new File(args[FIRST]);
			if (!extractHtmlFiles(srcDir))
				return false;
			outDir = new File(args[SECOND]);
			if (!outDir.exists()) {
				System.out.println(Messages.PATH_EXIST_ERR + outDir.getAbsolutePath());
				return false;
			}
			return true;
		}
		return true;
	}

	private boolean extractHtmlFiles(File srcDir) {
		if (!srcDir.exists() || !srcDir.isDirectory())
			return false;
		filterHtmlFiles(srcDir.listFiles());
		return true;
	}

	private void filterHtmlFiles(File[] files) {
		Logger.getGlobal().info("Filter");
		for (File file : files) {
			if (!file.exists()) {
				Logger.getGlobal().info("File " + file + " does not exists");
				continue;
			}
			if (!file.getExtension().equals(Constants.HTML_EXTENSION)) {
				Logger.getGlobal().info("File " + file + " is not HTML file, ignoring");
				continue;
			}
			htmlPaths.add(path);
		}
		return htmlPaths;
	}

}
