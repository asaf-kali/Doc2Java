package doc2java.main;

import doc2java.struct.Class;

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
		List<Class> classes = new LinkedList<>();
		int parsedCount = 0;
		for (File file : arguments.files) {
			try {
				Class cls = new Class(file);
				classes.add(cls);
				parsedCount++;
			} catch (Exception e) {
				Log.warning("Failed parsing file " + prm(file) + ": " + e.getMessage());
			}
		}
		Log.info("Parsed " + prm(parsedCount) + " file(s) out of " + prm(arguments.files.size()));
		for (Class cls : classes) {
			cls.toFile();
		}
	}

}
