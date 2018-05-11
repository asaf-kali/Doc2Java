package doc2java.main;


import org.joda.time.DateTime;

public class Utils {

	public static String nowString(DateFormat format) {
		return DateTime.now().toString(format.getFormat());
	}

}

enum DateFormat {

	FileName("YYYY-MM-dd HH.mm.ss"), Log("YYYY-MM-dd HH:mm:ss");

	private final String format;

	DateFormat(String format) {
		this.format = format;
	}

	public String getFormat() {
		return format;
	}
}
