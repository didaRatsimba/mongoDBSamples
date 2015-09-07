/**
 *
 */
package mg.dida.samplemongojee.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.jee.MongoHolder;
import com.mongodb.jee.servlet.ServletHelper;

/**
 * @author Dida
 *
 */
public class LogServlet extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = -6967292228718268066L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Mongo mongo = MongoHolder.connect();
		// Get DB collection
		DB db = mongo.getDB("websites");
		DBCollection coll = db.getCollection("logs");

		DBCursor cursor = coll.find();

		//		// HTTP response is JSON
		//		response.setCharacterEncoding("UTF-8");
		//		response.setContentType("application/json");
		//
		//		// Loop for DB cursor and write each DB document in the HTTP writer
		//		Writer writer = response.getWriter();
		//
		//		JSON.serialize(cursor, writer);
		//		//		writer.write(buf.toString());
		//
		//		writer.flush();
		ServletHelper.writeJson(cursor, response);

	}

}
