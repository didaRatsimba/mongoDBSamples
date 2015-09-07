package mg.dida.samples.mvn.mongo.samplemvn.javadriver;

import java.net.UnknownHostException;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class FindLogsWithMongoJavaDriver_0 {

	public void find() throws UnknownHostException {

		// Connect to Mongo DB
		MongoClientURI mongoURI = new MongoClientURI("mongodb://localhost:27017");
		MongoClient mongo = new MongoClient(mongoURI);
		try {

			// Get "logs" collection from the "websites" DB.
			MongoDatabase db = mongo.getDatabase("websites");
			MongoCollection<Document> coll = db.getCollection("logs");

			// Find all DB object from the DB collection
			//			Document log = null;
			System.out.println(coll.count());
			FindIterable<Document> cursor = coll.find();

			// Loop for each db object of the cursor.
			//			while (cursor.iterator().hasNext()) {
			//				log = cursor.iterator().next();
			//				System.out.println(log.toString());
			//			}

			//JAVA 8 : these codes become
			//			cursor.forEach(new Block<Document>() {
			//
			//				@Override
			//				public void apply(Document t) {
			//					System.out.println(t.toString());
			//
			//				}
			//			});

			cursor.forEach((Block<Document>) t -> System.out.println(t.toString()));
		} finally {
			// close mongo connection
			mongo.close();
		}

	}
}
