import doc2java.main.Doc2Java;
import doc2java.struct.Class;
import doc2java.struct.Package;
import org.junit.Test;

public class Tests {

	private static final String cwd = System.getProperty("user.dir") + "\\";
	private static final String test_resource = cwd + "test_resource\\";
	private static final String test_result = cwd + "test_result\\";

	private static final String example1 = "example 1\\";


	@Test
	public void test1() {
		String[] args = {test_resource + example1, test_result + example1};
		Doc2Java.main(args);
	}

	@Test
	public void test2() {
		Package parent, project, child, brother;
		project = new Package("project");
		parent = new Package("parent");
		child = new Package("child");
		brother = new Package("brother");
		parent.addChild(project);
		project.addChild(child);
		brother.setParent(parent);
		Class cls = new Class();

	}

}