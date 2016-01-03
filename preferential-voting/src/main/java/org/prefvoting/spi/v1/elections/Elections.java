package org.prefvoting.spi.v1.elections;

import javax.servlet.ServletContext;

import org.prefvoting.spi.BaseApi;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;

@Api(
		name = "pv",
		title = "Preferential Voting",
		canonicalName = "PreferentialVoting",
		version = "v1",
		description = "API for managing elections and voting."
)
public class Elections {
	
	@ApiMethod(
		name = "elections.get",
		httpMethod = HttpMethod.GET
	)
	public ElectionBean get(ServletContext context) {
		ElectionBean ret =  new ElectionBean();
		SampleDependency dependency = BaseApi.getComponentFromContext(context).dependency();
		ret.test = dependency.getString();
		return ret;
	}
	
	@ApiMethod(
		name = "elections.post",
		httpMethod = HttpMethod.POST
	)
	public ElectionBean post(ElectionBean input) {
		return input;
	}
}