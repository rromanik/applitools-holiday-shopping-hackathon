package com.applitools.applifashion.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class ConfigurationManager {

	private static final String CONFIG_PROPERTIES_FILE_NAME = "config.properties";

	private static final Properties configProperties = new Properties();

	private static final Map<String, String> propertyMap = new ConcurrentHashMap<>();

	public static String getAppUrl() {
		return getProperty("app.url");
	}

	public static String getUfgBrowserConfig() {
		return getProperty("ufg.browser.config");
	}

	public static String getAppName() {
		return getProperty("app.name");
	}

	public static String getApplitoolsApiKey() {
		return getProperty("applitools.api.key");
	}

	public static String getProperty(String key) {
		return propertyMap.computeIfAbsent(key, ConfigurationManager::computeProperty);
	}

	private static String computeProperty(String propertyName) {
		String property = System.getProperty(propertyName);
		if (StringUtils.isNotEmpty(property))
			return property;
		return getPropertyFromConfigFiles(propertyName);
	}

	private static String getPropertyFromConfigFiles(String key) {
		return getConfigProperties().getProperty(key);
	}

	private static Properties getConfigProperties() {
		if (configProperties.isEmpty())
			initProperties();
		return configProperties;
	}

	private static void initProperties() {
		readPropertiesFromResource(CONFIG_PROPERTIES_FILE_NAME);
		updateWithProfileProperties();
	}

	private static void updateWithProfileProperties() {
		String profile = System.getProperty("profile");
		if (StringUtils.isEmpty(profile))
			return;
		String profileProperties = profile + ".properties";
		readPropertiesFromResource(profileProperties);
	}

	private static void readPropertiesFromResource(String name) {
		try (InputStream inputStream = getResourceAsStream(name)) {
			if (inputStream == null) {
				throw new RuntimeException("Configuration Manager couldn't read properties from resource: " + name);
			}
			configProperties.load(inputStream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static InputStream getResourceAsStream(String name) {
		return ConfigurationManager.class.getClassLoader().getResourceAsStream(name);
	}
}
