package doc2java.struct;

import doc2java.main.File;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


public class Package {

	/* --- Constants --- */

	private static String DEFAULT_PACKAGE = "default";

	/* --- Fields --- */

	String name;
	private Package parent;
	private Set<Package> children;

	/* --- Constructors --- */

	public Package() {
		this(DEFAULT_PACKAGE);
	}

	public Package(String name) {
		this.name = name;
		this.children = new HashSet<>();
	}

	public Package(String name, Package parent) {
		this(name);
		setParent(parent);
	}

	/* --- Methods --- */

	public void addChild(Package child) {
		if (child == null)
			return;
		if (children.contains(child))
			return;
		children.add(child);
		child.setParent(this);
	}

	public void setParent(Package parent) {
		if (parent == null)
			return;
		if (this.parent == parent)
			return;
		this.parent = parent;
		parent.addChild(this);
	}

	public File generateHierarchy(File dir) throws IOException {
		// Validate directory exists
		if (!dir.validateIsDir())
			return null;
		// Validate parent matches directory
		if (parent != null)
			if (!dir.getName().equals(parent.name))
				dir = parent.generateHierarchy(dir);
		// Create directory for this
		File pkgDir = new File(dir, name);
		if (!pkgDir.exists())
			if (!pkgDir.mkdir())
				throw new IOException("Failed creating directory: " + pkgDir);
		// Create directories for children
		for (Package child : children)
			child.generateHierarchy(pkgDir);
		// return this directory
		return pkgDir;
	}

	@Override
	public String toString() {
		String parentStr = "";
		if (parent != null)
			parentStr = parent.toString() + ".";
		return parentStr + name;
	}

	/* --- Getters & Setters --- */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
