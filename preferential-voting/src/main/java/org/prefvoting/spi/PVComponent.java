package org.prefvoting.spi;

import org.prefvoting.spi.v1.elections.SampleDependency;

import dagger.Component;

/**
 * Dagger component that provides all dependencies needed by the API.
 */
@Component
public interface PVComponent {

	public SampleDependency dependency();
}
