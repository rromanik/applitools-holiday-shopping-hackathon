package com.applitools.applifashion.ufg;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.config.Configuration;

public interface UfgBrowserConfigurator {

	RectangleSize DEFAULT_VIEW_PORT = new RectangleSize(1200, 800);

	void configureBrowsers(Configuration configuration);

}
