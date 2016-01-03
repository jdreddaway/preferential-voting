package org.prefvoting.spi;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class PVServletContextListener implements ServletContextListener {
	
	/**
	 * The name used for the attribute in the ServletContext.
	 */
	public static final String INJECTOR_ATTRIBUTE = "PVComponent";
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		PVComponent component = DaggerPVComponent.create();
		event.getServletContext().setAttribute(INJECTOR_ATTRIBUTE, component);
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) { }
}
