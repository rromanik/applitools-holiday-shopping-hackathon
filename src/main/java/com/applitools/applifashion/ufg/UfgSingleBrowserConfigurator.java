package com.applitools.applifashion.ufg;

import com.applitools.eyes.config.Configuration;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.visualgrid.model.DesktopBrowserInfo;

public class UfgSingleBrowserConfigurator implements UfgBrowserConfigurator {

	@Override
	public void configureBrowsers(Configuration configuration) {
		DesktopBrowserInfo defaultBrowser = new DesktopBrowserInfo(DEFAULT_VIEW_PORT, BrowserType.CHROME);
		configuration.addBrowser(defaultBrowser);
	}
}
