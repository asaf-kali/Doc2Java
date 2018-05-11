/**
 *
 */
public class Javadoc {

	private static final String OPEN = "/**\n";
	private static final String ROW = " * %s\n";
	private static final String CLOSE = " */\n";

	String description;

	@Override
	public String toString() {
		return OPEN + String.format(ROW, description) + CLOSE;
	}
}
