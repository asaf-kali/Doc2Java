package doc2java.main;

import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class File extends java.io.File {

	/* --- Constructors --- */

	public File(String pathname) {
		super(pathname);
	}

	public File(java.io.File file, String pathname) {
		super(file, pathname);
	}

	/* --- Methods --- */

	public String getExtension() {
		return FilenameUtils.getExtension(getFullPath());
	}

	public String getFullPath() {
		String fileName;
		try {
			fileName = this.getCanonicalPath();
		} catch (Exception e) {
			fileName = this.getAbsolutePath();
		}
		return fileName;
	}

	public boolean validateIsDir() throws IOException {
		if (!exists())
			throw new IOException(Messages.PATH_EXIST_ERR + getFullPath());
		if (!isDirectory())
			throw new IOException(Messages.PATH_NOT_DIR + getFullPath());
		return true;
	}

	@Override
	public String toString() {
		// TODO: Maybe just name?
		return getFullPath();
	}

	/* --- Static --- */

	public static Collection<File> fromArray(java.io.File[] files) {
		List<File> list = new ArrayList<>(files.length);
		for (java.io.File file : files)
			list.add(new File(file.getAbsolutePath()));
		return list;
	}

}
