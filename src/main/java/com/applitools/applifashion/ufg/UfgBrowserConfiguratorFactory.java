package com.applitools.applifashion.ufg;

public class UfgBrowserConfiguratorFactory {

	private static final String SINGLE = "single";

	private static final String MULTIPLE = "multiple";

	public UfgBrowserConfigurator getUfgBrowserConfigurator(String configurator){
		switch (configurator.toLowerCase()){
			case MULTIPLE:
				return new UfgMultipleBrowserConfigurator();
			case SINGLE:
			default:
				return new UfgSingleBrowserConfigurator();
		}
	}
}
