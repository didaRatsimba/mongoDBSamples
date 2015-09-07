/**
 *
 */
package mg.dida.samplemongojeewithjax.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import mg.dida.samplemongojeewithjax.services.LogsServices;

/**
 * @author Dida
 *
 */
public class OwnApplication extends Application {

	private final Set<Class<?>> clazz;

	public OwnApplication() {
		clazz = new HashSet<>();
		addClass();
	}

	@Override
	public Set<Class<?>> getClasses() {
		return clazz;
	}

	protected void addClass(){
		clazz.add(LogsServices.class);
	}



}
