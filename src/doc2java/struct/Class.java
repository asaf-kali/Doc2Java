package doc2java.struct;

import doc2java.main.File;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.LinkedList;

public class Class {

	/* --- Constants --- */

	private static final String JAVA_EXT = ".java";

	/* --- Fields --- */

	String name;
	Package pkg;
	Collection<Member> members;
	Collection<Class> subClasses;
	Javadoc javadoc;

	/* --- Constructors --- */

	public Class() {
		this.members = new LinkedList<>();
		this.subClasses = new LinkedList<>();
		this.pkg = new Package();
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

	/* --- Methods --- */

	public void saveUnder(File outFolder) throws IOException {
		outFolder = pkg.generateHierarchy(outFolder);
		File outFile = new File(outFolder, name + JAVA_EXT);
		PrintWriter writer = new PrintWriter(outFile);
		String content = toFile();
		writer.print(content);
		writer.close();
	}

	public String toFile() {
		String file = "";

		return file;
	}

	/* --- Getters & Setters --- */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Package getPkg() {
		return pkg;
	}

	public void setPkg(Package pkg) {
		this.pkg = pkg;
	}

	public Collection<Member> getMembers() {
		return members;
	}

	public void setMembers(Collection<Member> members) {
		this.members = members;
	}

	public Collection<Class> getSubClasses() {
		return subClasses;
	}

	public void setSubClasses(Collection<Class> subClasses) {
		this.subClasses = subClasses;
	}

	public Javadoc getJavadoc() {
		return javadoc;
	}

	public void setJavadoc(Javadoc javadoc) {
		this.javadoc = javadoc;
	}

	/* --- Static --- */

	public static Class parseClass(Document document) {
		return new Class(document);
	}

}
