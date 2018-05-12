import doc2java.main.Doc2Java;
import doc2java.main.File;
import doc2java.struct.Class;
import doc2java.struct.Package;
import org.junit.Test;

import java.io.IOException;

public class Tests {

	/* --- Constants --- */

	private static final String cwd = System.getProperty("user.dir") + "\\";
	private static final String test_resource = cwd + "test_resource\\";
	private static final String test_result = cwd + "test_result\\";

	private static final String example1 = "example 1\\";

	/* --- Tests --- */

	@Test
	public void test1() {
		String[] args = {test_resource + example1, test_result + example1};
		Doc2Java.main(args);
	}

	@Test
	public void fileSaved() throws IOException {
		Class cls = new Class();
		cls.setName("test");
		cls.saveUnder(new File(test_result + example1));
	}

	@Test
	public void packageStructure() throws IOException {
		Package parent, project, child, brother;
		project = new Package("project");
		parent = new Package("parent");
		child = new Package("child");
		brother = new Package("brother");
		parent.addChild(project);
		project.addChild(child);
		brother.setParent(parent);
		project.generateHierarchy(new File(test_result));
	}

}