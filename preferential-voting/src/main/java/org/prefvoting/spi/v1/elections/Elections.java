package org.prefvoting.spi.v1.elections;

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
	public ElectionBean get() {
		ElectionBean ret =  new ElectionBean();
		ret.test = "Hello?!?";
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