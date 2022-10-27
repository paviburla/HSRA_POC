package Runner;

import org.junit.runner.JUnitCore;
public class MainRunner {

	public static void main(String[] args) {

		JUnitCore.runClasses(TestRunner.class);
	}

}
