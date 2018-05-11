package doc2java.main;

import org.apache.commons.io.FilenameUtils;

import java.io.IOException;

public class File extends java.io.File {

	public File(String pathname) {
		super(pathname);
	}

	public String getExtension() {
		// TODO: Check if this is .getName()
		String fileName;
		try {
			fileName = this.getCanonicalPath();
		} catch (Exception e) {
			fileName = this.getPath();
		}
		return FilenameUtils.getExtension(fileName);
	}
}
