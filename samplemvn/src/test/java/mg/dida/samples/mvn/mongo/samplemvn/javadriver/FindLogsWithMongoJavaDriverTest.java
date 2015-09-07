package mg.dida.samples.mvn.mongo.samplemvn.javadriver;

import org.junit.Test;

public class FindLogsWithMongoJavaDriverTest {

	@Test
	public void testFind() {
		FindLogsWithMongoJavaDriver findLogsWithMongoJavaDriver = new FindLogsWithMongoJavaDriver();
		try{
			findLogsWithMongoJavaDriver.find();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
