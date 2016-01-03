package org.prefvoting.spi.v1.elections;

import javax.inject.Inject;

/**
 * Test dependency to make sure that DI is working.
 * TODO delete this class
 */
public class SampleDependency {

	@Inject
	public SampleDependency() { /* empty for dagger */ }
	
	public String getString() {
		return "Hello assassin!";
	}
}
