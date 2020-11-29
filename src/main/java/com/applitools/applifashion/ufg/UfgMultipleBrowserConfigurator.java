package com.applitools.applifashion.ufg;

import com.applitools.eyes.config.Configuration;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;

public class UfgMultipleBrowserConfigurator implements UfgBrowserConfigurator {

	@Override
	public void configureBrowsers(Configuration configuration) {
		configuration.addBrowser(1200, 800, BrowserType.CHROME);
		configuration.addBrowser(1200, 800, BrowserType.FIREFOX);
		configuration.addBrowser(1200, 800, BrowserType.EDGE_CHROMIUM);
		configuration.addBrowser(1200, 800, BrowserType.SAFARI);
		configuration.addDeviceEmulation(DeviceName.iPhone_X, ScreenOrientation.PORTRAIT);
	}
}
