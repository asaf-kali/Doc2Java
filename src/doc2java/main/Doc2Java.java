package doc2java.main;

public class Doc2Java {

	public static void main(String[] args) {
		Log.initLogger();
		D2JArgs arguments = new D2JArgs(args);
		if (!arguments.parseSuccess) {
			System.out.println(Messages.ARGS_ERR);
			return;
		}
		System.out.println("dudi");
	}

}
