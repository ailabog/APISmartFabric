package com.agys.utils;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */

public class CredentialsUtils {

	private static final Logger logger = LoggerFactory.getLogger(CredentialsUtils.class);
	private static final Properties properties = loadProperties();

	private static Properties loadProperties() {
		try {
			Properties prop = new Properties();
			prop.load(CredentialsUtils.class.getClassLoader().getResourceAsStream("credentials.properties"));
			return prop;
		} catch (IOException e) {
			logger.error("Error ocured while loading properties {}", e.getMessage());
			throw new RuntimeException(e);
		}
	}

	public static String getProperty(String property) {
		return properties.getProperty(property);
	}
}

