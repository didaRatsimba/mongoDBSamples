package mg.dida.samples.mvn.mongo.samplemvn.javadriver;

import java.net.UnknownHostException;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

public class FindLogsWithMongoJavaDriver {

	public void find() throws UnknownHostException {

		// Connect to Mongo DB
		MongoClientURI mongoURI = new MongoClientURI("mongodb://localhost:27017");
		MongoClient mongo = new MongoClient(mongoURI);
		try {

			// Get "logs" collection from the "websites" DB.
			MongoDatabase db = mongo.getDatabase("websites");
			MongoCollection<Document> coll = db.getCollection("logs");

			// Find all DB object from the DB collection
			FindIterable<Document> cursor = coll.find();
			System.out.println("collection size " + coll.count());

			// Generate JSON array of the cursor.
			StringBuilder buf = new StringBuilder();
			JSON.serialize(cursor, buf);
			System.out.println(buf.toString());

		} finally {
			// close mongo connection
			mongo.close();
		}

	}
}
