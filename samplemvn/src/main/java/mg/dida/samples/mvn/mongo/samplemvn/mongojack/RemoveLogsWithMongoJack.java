package mg.dida.samples.mvn.mongo.samplemvn.mongojack;

import java.net.UnknownHostException;

import org.mongojack.JacksonDBCollection;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class RemoveLogsWithMongoJack {

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

			// remove all logs
			coll.remove(new BasicDBObject());

		} finally {
			// close mongo connection
			mongo.close();
		}

	}
}
