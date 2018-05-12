package doc2java.main;

import doc2java.struct.Class;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static doc2java.main.Log.prm;

public class Doc2Java {

	public static void main(String[] args) {
		Log.initLogger();
		D2JArgs arguments = new D2JArgs(args);
		if (!arguments.parseSuccess) {
			System.out.println(Messages.ARGS_ERR);
			return;
		}
		List<Class> classes = parseFiles(arguments.files);
		saveClasses(classes, arguments.outDir);
	}

	private static List<Class> parseFiles(List<File> files) {
		List<Class> classes = new LinkedList<>();
		for (File file : files) {
			try {
				Class cls = new Class(file);
				classes.add(cls);
			} catch (Exception e) {
				Log.warning("Failed parsing file " + prm(file) + ": " + e.getMessage());
			}
		}
		Log.info("Parsed " + prm(classes.size()) + " file(s) out of " + prm(files.size()));
		return classes;
	}

	private static void saveClasses(List<Class> classes, File outDir) {
		int saveCount = 0;
		for (Class cls : classes) {
			try {
				cls.saveUnder(outDir);
				saveCount++;
			} catch (IOException e) {
				Log.warning("Failed saving class " + prm(cls) + e.getMessage());
			}
		}
		Log.info("Saved " + prm(saveCount) + " file(s) out of " + prm(classes.size()));
	}
}
