package org.prefvoting.spi.v1;

import com.google.api.server.spi.config.Api;

@Api (
	name = "pv",
	title = "Preferential Voting",
	canonicalName = "PreferentialVoting",
	version = "v1",
	description = "API for managing elections and voting."
)
public class BaseApi { }
