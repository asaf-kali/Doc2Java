package doc2java.main;

class Constants {

	static final int MIN_ARGS = 1;
	static final int TWO_ARGS = 2;
	static final int MAX_ARGS = 1;
	static final String HTML_EXTENSION = "html";
	static final String DEFAULT_OUT_DIR = "Doc2Java";

}

class Messages {

	static final String USAGE = "You can use one of the following: " +
			"	doc2java <source_dir> // Files will be created inside <source_dir>\\Doc2Java\\" +
			"	doc2java <source_dir> <output_dir> // If <output_dir> does not exist, it will be created" +
			"	doc2java <file1, file2, ...> <output_dir>";

	static final String ARGS_ERR = "Problem parsing given arguments. " + USAGE;
	static final String PATH_EXIST_ERR = "Given path does not exists: ";
	static final String PATH_NOT_DIR = "Given path is not a directory: ";
	static final String FILE_TYPE_ERR = "Given path is not an HTML file: ";
	static final String MKDIR_FAIL = "Failed to create directory: ";
}
