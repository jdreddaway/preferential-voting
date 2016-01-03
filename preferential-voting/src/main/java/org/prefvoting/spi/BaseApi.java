package org.prefvoting.spi;

import javax.servlet.ServletContext;

/**
 * TODO make this use @Api and the endpont classes reference it using @ApiReference.
 * 	For some reason, this wasn't working before. See
 * 	http://stackoverflow.com/questions/34507555/endpoints-get-discovery-doc-ignores-web-xml-servlet-services
 */
public class BaseApi {

	public static PVComponent getComponentFromContext(ServletContext context) {
		return (PVComponent) context.getAttribute(PVServletContextListener.INJECTOR_ATTRIBUTE);
	}
}
