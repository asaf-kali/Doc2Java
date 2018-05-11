package doc2java.struct;

import org.jsoup.nodes.Document;

import java.util.LinkedList;
import java.util.List;

public class Class {

	List<Member> members;
	Javadoc javadoc;

	public Class() {
		this.members = new LinkedList<>();
		this.javadoc = new Javadoc();
	}

	public Class(String fileName) {
		this(Document.createShell(fileName));
	}

	public Class(Document document) {
		this();

	}

	public String toFile() {
		String file = "";

		return file;
	}

	public static Class parseClass(Document document) {
		return new Class(document);
	}

}
