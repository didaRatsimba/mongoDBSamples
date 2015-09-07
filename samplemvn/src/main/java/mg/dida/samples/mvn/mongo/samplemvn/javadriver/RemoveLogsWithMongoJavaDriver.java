package mg.dida.samples.mvn.mongo.samplemvn.javadriver;

import java.net.UnknownHostException;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class RemoveLogsWithMongoJavaDriver {

	public void remove() throws UnknownHostException {

		// Connect to Mongo DB
		MongoClientURI mongoURI = new MongoClientURI("mongodb://localhost:27017");
		MongoClient mongo = new MongoClient(mongoURI);
		try {

			// Get "logs" collection from the "websites" DB.
			MongoDatabase db = mongo.getDatabase("websites");
			MongoCollection<Document> coll = db.getCollection("logs");

			// remove all logs
			coll.drop();

		} finally {
			// close mongo connection
			mongo.close();
		}

	}
}
