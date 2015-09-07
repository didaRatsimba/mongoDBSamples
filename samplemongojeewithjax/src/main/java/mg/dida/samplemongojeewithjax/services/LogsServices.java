/**
 *
 */
package mg.dida.samplemongojeewithjax.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.jee.MongoHolder;
import com.mongodb.jee.util.JSON;

/**
 * @author Dida
 *
 */
@Path("/logs")
public class LogsServices {

	@SuppressWarnings("deprecation")
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		DB db = MongoHolder.connect().getDB("websites");
		DBCollection coll = db.getCollection("logs");
		final DBCursor cursor = coll.find();

		//java 8
		//		StreamingOutput output = new StreamingOutput() {
		//
		//			@Override
		//			public void write(OutputStream out) throws IOException, WebApplicationException {
		//					JSON.serialize(cursor, out);
		//
		//			}
		//		};

		StreamingOutput output = out -> JSON.serialize(cursor, out);
		return Response.ok(output).build();
	}

}
