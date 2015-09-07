/**
 *
 */
package mg.dida.samplemongojeewithjax.server;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * @author Dida
 *
 */
public class StartServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Server server = new Server(8081);

		WebAppContext context = new WebAppContext("src/main/webapp/", "/mongo");

		ContextHandlerCollection servletContexts = new ContextHandlerCollection();
		context.setClassLoader(Thread.currentThread()
				.getContextClassLoader());
		HandlerCollection handlers = new HandlerCollection();
		handlers.setHandlers(new Handler[] { servletContexts, context,
				new DefaultHandler() });
		server.setHandler(handlers);

		try {
			server.start();
			server.join();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
