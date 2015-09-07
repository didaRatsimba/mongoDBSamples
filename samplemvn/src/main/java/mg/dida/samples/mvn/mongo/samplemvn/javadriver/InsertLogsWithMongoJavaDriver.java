package mg.dida.samples.mvn.mongo.samplemvn.javadriver;

import java.net.UnknownHostException;
import java.util.Calendar;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class InsertLogsWithMongoJavaDriver {

	public void insert() throws UnknownHostException {

		// Connect to Mongo DB
		MongoClientURI mongoURI = new MongoClientURI("mongodb://localhost:27017");
		MongoClient mongo = new MongoClient(mongoURI);
		try {

			// Get "logs" collection from the "websites" DB.
			MongoDatabase db = mongo.getDatabase("websites");
			MongoCollection<Document> coll = db.getCollection("logs");

			// Insert logs with DB object
			Document log = null;
			for (int i = 0; i < 100; i++) {
				log = new Document();
				log.put("url", "https://github.com/mongodb/mongo-java-driver");
				log.put("created", Calendar.getInstance().getTime());
				coll.insertOne(log);
			}

		} finally {
			// close mongo connection
			mongo.close();
		}

	}
}