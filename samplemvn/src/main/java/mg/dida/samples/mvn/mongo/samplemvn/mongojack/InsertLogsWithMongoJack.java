package mg.dida.samples.mvn.mongo.samplemvn.mongojack;

import java.net.UnknownHostException;
import java.util.Calendar;

import org.mongojack.JacksonDBCollection;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class InsertLogsWithMongoJack {

	public static void main(String[] args) throws UnknownHostException {

		// Connect to Mongo DB
		MongoClientURI mongoURI = new MongoClientURI("mongodb://localhost:27017");
		MongoClient mongo = new MongoClient(mongoURI);
		try {

			// Get "logs" collection from the "websites" DB.
			DB db = mongo.getDB("websites");
			DBCollection dbColl = db.getCollection("logs");

			// Use Pojo Mapper MongoJack
			JacksonDBCollection<Log, String> coll = JacksonDBCollection.wrap(dbColl, Log.class, String.class);

			// Insert logs with Pojo Log
			Log log = null;
			for (int i = 0; i < 100; i++) {
				log = new Log();
				log.setUrl("http://mongojack.org/");
				log.setCreated(Calendar.getInstance().getTime());
				coll.insert(log);
			}

		} finally {
			// close mongo connection
			mongo.close();
		}

	}
}