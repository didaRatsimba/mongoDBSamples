package mg.dida.samples.mvn.mongo.samplemvn.mongojack;

import java.io.IOException;

import org.mongojack.DBCursor;
import org.mongojack.JacksonDBCollection;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class FindPaginatedLogsWithMongoJack {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

		// Connect to Mongo DB
		MongoClientURI mongoURI = new MongoClientURI("mongodb://localhost:27017");
		MongoClient mongo = new MongoClient(mongoURI);
		try {

			// Get "logs" collection from the "websites" DB.
			DB db = mongo.getDB("websites");
			DBCollection dbColl = db.getCollection("logs");

			// Use Pojo Mapper MongoJack
			JacksonDBCollection<Log, String> coll = JacksonDBCollection.wrap(dbColl, Log.class, String.class);

			// Find paginated Pojo Log from the MongoJack collection
			int pageIndex = 0;
			int pageSize = 5;
			DBCursor<Log> cursor = coll.find().skip(pageIndex).limit(pageSize);

			// Serialize list of Log as JSON
			ObjectMapper om = new ObjectMapper();
			om.writer().writeValue(System.err, cursor.toArray());

		} finally {
			// close mongo connection
			mongo.close();
		}

	}
}
