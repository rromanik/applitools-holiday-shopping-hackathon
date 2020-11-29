package com.applitools.applifashion.utils;

import com.applitools.applifashion.pages.ui.AbstractGuiElement;
import com.applitools.applifashion.ufg.UfgBrowserConfigurator;
import com.applitools.applifashion.ufg.UfgBrowserConfiguratorFactory;
import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;

import static com.applitools.applifashion.pages.AppliFashionApp.getDriver;
import static com.applitools.applifashion.utils.ConfigurationManager.*;
import static com.applitools.applifashion.utils.ConfigurationManager.getAppName;
import static com.applitools.applifashion.utils.ConfigurationManager.getUfgBrowserConfig;

public class EyesManager {
	private static final BatchInfo BATCH_INFO = new BatchInfo("Holiday Shopping");

	private final VisualGridRunner runner;
	private final Eyes eyes;

	public EyesManager() {
		this.runner = new VisualGridRunner(5);
		this.eyes = new Eyes(runner);
		setUp();
	}

	private void setUp() {
		Configuration config = new Configuration();
		config.setApiKey(getApplitoolsApiKey());
		config.setBatch(BATCH_INFO);

		setUpBrowsers(config);

		eyes.setConfiguration(config);
	}

	private void setUpBrowsers(Configuration config) {
		UfgBrowserConfiguratorFactory factory = new UfgBrowserConfiguratorFactory();
		UfgBrowserConfigurator browserConfigurator = factory
				.getUfgBrowserConfigurator(getUfgBrowserConfig());
		browserConfigurator.configureBrowsers(config);
	}

	public void validateWindowFully(String testName, String stepName) {
		eyes.open(getDriver(), getAppName(), testName);
		eyes.check(Target.window().fully().withName(stepName));
		eyes.closeAsync();
	}

	public void validateRegion(String testName, String stepName, AbstractGuiElement guiElement) {
		eyes.open(getDriver(), getAppName(), testName);
		eyes.check(stepName, Target.region(guiElement.getWrappedElement()));
		eyes.closeAsync();
	}

	public TestResultsSummary getAllTestResults(boolean shouldThrowException) {
		return runner.getAllTestResults(shouldThrowException);
	}

}
