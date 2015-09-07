package mg.dida.samples.mvn.mongo.samplemvn.javadriver;

import org.junit.Test;

public class FindLogsWithMongoJavaDriver_0Test {

	@Test
	public void testFind() {
		FindLogsWithMongoJavaDriver_0 findLog = new FindLogsWithMongoJavaDriver_0();
		try{
			findLog.find();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
