/**
 *
 */
package mg.dida.samplemvnjee.servlet;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

/**
 * @author Dida
 *
 */
public class LogsServlet extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 6393295218810912545L;

	private MongoClient mongo = null;

	@Override
	public void init() throws ServletException {
		super.init();

		// Connect to Mongo DB
		MongoClientURI mongoURI = new MongoClientURI(
				"mongodb://localhost:27017");
		try {
			mongo = new MongoClient(mongoURI);
		} catch (MongoException e) {
			throw new ServletException(e);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Get "logs" collection from the "websites" DB.
		MongoDatabase db = mongo.getDatabase("websites");
		MongoCollection<Document> coll = db.getCollection("logs");

		// Find all DB object from the DB collection
		FindIterable<Document> cursor = coll.find();

		// HTTP response is JSON
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");

		// Write in the HTTP response, the JSON array of the cursor.
		Writer writer = response.getWriter();
		StringBuilder buf = new StringBuilder();
		JSON.serialize(cursor, buf);
		writer.write(buf.toString());
		writer.flush();

	}

	@Override
	public void destroy() {
		super.destroy();
		if (mongo != null) {
			mongo.close();
		}
	}



}
