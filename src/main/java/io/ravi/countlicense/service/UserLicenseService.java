package io.ravi.countlicense.service;

import java.util.List;
import java.util.Map;

public interface UserLicenseService {
	Map<String,Object> getUserLicenseDetails(Long userId);
	List<Map<String, Object>> getAllUserLicenseDetails();
}

