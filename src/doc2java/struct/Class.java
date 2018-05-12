package doc2java.struct;

import doc2java.main.File;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Class {

	Collection<Member> members;
	Collection<Class> subClasses;
	Javadoc javadoc;
	Package pack;

	public Class() {
		this.members = new LinkedList<>();
		this.javadoc = new Javadoc();
	}

	public Class(File file) {
		this(file.getFullPath());
	}

	public Class(String fileName) {
		this(Document.createShell(fileName));
	}

	public Class(Document document) {
		this();
	}

	public String toFile(File outFolder) throws IOException {
		String file = "";

		return file;
	}

	public static Class parseClass(Document document) {
		return new Class(document);
	}

}
