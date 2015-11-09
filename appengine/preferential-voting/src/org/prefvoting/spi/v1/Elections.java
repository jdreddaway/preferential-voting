package org.prefvoting.spi.v1;

import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiReference;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;

@ApiReference(BaseApi.class)
public class Elections {

	@ApiMethod (
		name = "elections.get",
		path = "elections",
		httpMethod = HttpMethod.GET
	)
	public ElectionBean get() {
		ElectionBean ret =  new ElectionBean();
		ret.test = "Hello?!?";
		return ret;
	}
	
	@ApiMethod (
		name = "elections.post",
		path = "elections",
		httpMethod = HttpMethod.POST
	)
	public ElectionBean post(ElectionBean input) {
		return input;
	}
}
