package doc2java.struct;

import java.lang.reflect.Type;

/**
 * Represents a member inside a class
 */
public class Member {

	AccessModifier accessModifier;
	boolean isAbstract;
	boolean isStatic;
	boolean isFinal;
	Type type;
	String name;
	Javadoc javadoc;


}
