import java.util.LinkedList;
import java.util.List;

public class Class {

	List<Member> members;
	Javadoc javadoc;

	public Class(){
		this.members = new LinkedList<>();
		this.javadoc = new Javadoc();
	}

}
