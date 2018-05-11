package doc2java.main;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static doc2java.main.Log.prm;

class D2JArgs {

	private static final int FIRST = 0;
	private static final int SECOND = 1;

	List<File> files;
	File outDir;
	final boolean parseSuccess;

	D2JArgs(String[] args) {
		files = new LinkedList<>();
		parseSuccess = parseArgs(args);
		if (parseSuccess)
			Log.fine("Finished parsing successfully.");
	}

	private boolean parseArgs(String[] args) {
		if (args == null)
			return false;
		int length = args.length;
		if (length < Constants.MIN_ARGS)
			return false;
		// Single argument case
		if (length == Constants.MIN_ARGS)
			return parse1arg(args[FIRST]);
		// Two arguments case
		if (length == Constants.TWO_ARGS)
			return parse2args(args[FIRST], args[SECOND]);
		// TODO: Complete third case with file list
		return true;
	}

	private boolean parse1arg(String srcPath) {
		File srcDir = new File(srcPath);
		if (!extractHtmlFiles(srcDir))
			return false;
		outDir = new File(srcDir, Constants.DEFAULT_OUT_DIR);
		if (!outDir.exists()) {
			Log.info("Creating output directory");
			if (!outDir.mkdir()) {
				Log.severe(Messages.MKDIR_FAIL + outDir.getAbsolutePath());
				return false;
			}
		} else Log.info("Output directory already exists");
		return true;
	}

	private boolean parse2args(String srcPath, String outPath) {
		File srcDir = new File(srcPath);
		if (!extractHtmlFiles(srcDir))
			return false;
		outDir = new File(outPath);
		if (!outDir.exists()) {
			Log.severe(Messages.PATH_EXIST_ERR + outDir.getAbsolutePath());
			return false;
		}
		return true;
	}

	private boolean extractHtmlFiles(File srcDir) {
		if (!srcDir.exists()) {
			Log.severe(Messages.PATH_EXIST_ERR + srcDir.getAbsolutePath());
			return false;
		}
		if (!srcDir.isDirectory()) {
			Log.severe(Messages.PATH_NOT_DIR + srcDir.getAbsolutePath());
			return false;
		}
		Collection<File> files = File.fromArray(srcDir.listFiles());
		filterHtmlFiles(files);
		return true;
	}

	private void filterHtmlFiles(Collection<File> files) {
		Log.fine("Filtering files from collection size " + prm(files.size()));
		for (File file : files) {
			if (!file.exists()) {
				Log.finest("File " + prm(file) + " does not exists, ignoring");
				continue;
			}
			if (!file.getExtension().equals(Constants.HTML_EXTENSION)) {
				Log.finest("File " + prm(file) + " is not an HTML file, ignoring");
				continue;
			}
			this.files.add(file);
		}
		Log.fine("Filtered list size is " + prm(this.files.size()));
	}

}
