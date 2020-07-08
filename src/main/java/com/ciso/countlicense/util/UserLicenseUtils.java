package com.ciso.countlicense.util;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserLicenseUtils {

	private static Logger logger = LogManager.getLogger("applogs");

	private UserLicenseUtils() {
	}

	public static Integer getLicenseCout(Map<String, Integer> computerTypes) {

		int noOfDesktop = 0;
		int noOfLaptop = 0;

		if (computerTypes.containsKey("DESKTOP")) {
			noOfDesktop = computerTypes.get("DESKTOP");
		}

		if (computerTypes.containsKey("LAPTOP")) {
			noOfLaptop = computerTypes.get("LAPTOP");
		}

		Integer extraLaptop = noOfLaptop - noOfDesktop;
		logger.trace("Extra Laptop ::{}", extraLaptop);
		if (extraLaptop > 0) {
			int license =  (int)Math.ceil(extraLaptop / 2f) + noOfDesktop;
			logger.trace("License details ::{}", license);
			return license;
		} else if (extraLaptop <= 0) {
			return noOfDesktop;
		}
		return 0;
	}

}
