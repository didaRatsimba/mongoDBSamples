package mg.dida.samples.mvn.mongo.samplemvn.javadriver;

import java.net.UnknownHostException;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

public class FindPaginatedLogsWithMongoJavaDriver {

	public void find() throws UnknownHostException {

		// Connect to Mongo DB
		MongoClientURI mongoURI = new MongoClientURI("mongodb://localhost:27017");
		MongoClient mongo = new MongoClient(mongoURI);
		try {

			// Get "logs" collection from the "websites" DB.
			MongoDatabase db = mongo.getDatabase("websites");
			MongoCollection<Document> coll = db.getCollection("logs");

			// Find paginated DB object from the DB collection
			int pageIndex = 0;
			int pageSize = 5;
			FindIterable<Document> cursor = coll.find().skip(pageIndex).limit(pageSize);

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
