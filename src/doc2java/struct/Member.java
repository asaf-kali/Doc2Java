package doc2java.struct;

import java.lang.reflect.Type;

/**
 * Represents a member inside a class
 */
public class Member {

	AccessModifier accessModifier;
	boolean isStatic;
	boolean isFinal;
	boolean isAbstract;
	Type type;
	String name;
	Javadoc javadoc;


}
