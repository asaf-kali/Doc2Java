package doc2java.main;

import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class File extends java.io.File {

	public File(String pathname) {
		super(pathname);
	}

	public File(java.io.File file, String pathname) {
		super(file, pathname);
	}

	public String getExtension() {
		return FilenameUtils.getExtension(getFullPath());
	}

	public String getFullPath() {
		String fileName ;
		try {
			fileName = this.getCanonicalPath();
		} catch (Exception e) {
			fileName = this.getAbsolutePath();
		}
		return fileName;
	}

	public static Collection<File> fromArray(java.io.File[] files) {
		List<File> list = new ArrayList<>(files.length);
		for (java.io.File file : files)
			list.add(new File(file.getAbsolutePath()));
		return list;
	}
}
