package com.ciso.countlicense.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciso.countlicense.entity.UserLicense;
import com.ciso.countlicense.repository.UserLicenseRepository;
import com.ciso.countlicense.util.UserLicenseUtils;

@Service
public class UserLicenseServiceImpl implements UserLicenseService {

	private static Logger logger = LogManager.getLogger("applogs");

	@Autowired
	private UserLicenseRepository userLicenseRepository;

	@Override
	public Map<String, Object> getUserLicenseDetails(Long userId) {
		Optional<List<UserLicense>> listUserLic = userLicenseRepository.findByUserId(userId);
		if (listUserLic.isPresent()) {

			Map<String, Object> result = new HashMap<>();
			result.put("userid", userId);

			List<Map<String, Object>> licList = new ArrayList<>();

			Map<Long, List<UserLicense>> userByAppId = listUserLic.get().stream()
					.collect(Collectors.groupingBy(UserLicense::getAppId));

			for (Map.Entry<Long, List<UserLicense>> userDtls : userByAppId.entrySet()) {
				Map<String, Object> appList = new HashMap<>();
				appList.put("appid", userDtls.getKey());
				Map<String, Integer> computerTypes = userDtls.getValue().stream()
						.filter(e -> e.getComputerType() != null).map(UserLicense::getComputerType)
						.map(String::toUpperCase).collect(Collectors.groupingBy(e -> e, Collectors.summingInt(x -> 1)));
				logger.trace("Machine details :: {}", computerTypes);
				int noOfLicenseReq = UserLicenseUtils.getLicenseCout(computerTypes);
				appList.put("nooflicense", noOfLicenseReq);
				licList.add(appList);
			}
			result.put("license", licList);
			return result;

		}
		return Map.of();
	}

	@Override
	public List<Map<String, Object>> getAllUserLicenseDetails() {
		List<UserLicense> usersList = userLicenseRepository.findAll();
		logger.trace("All users :: {}", usersList);
		if (!usersList.isEmpty()) {

			Map<Long, List<UserLicense>> usersLicense = usersList.stream()
					.collect(Collectors.groupingBy(UserLicense::getUserId));

			List<Map<String, Object>> resultList = new ArrayList<>();

			for (Map.Entry<Long, List<UserLicense>> user : usersLicense.entrySet()) {

				Map<String, Object> result = new HashMap<>();
				result.put("userid", user.getKey());

				List<Map<String, Object>> licList = new ArrayList<>();

				Map<Long, List<UserLicense>> userByAppId = user.getValue().stream()
						.collect(Collectors.groupingBy(UserLicense::getAppId));

				for (Map.Entry<Long, List<UserLicense>> userDtls : userByAppId.entrySet()) {
					Map<String, Object> appList = new HashMap<>();
					appList.put("appid", userDtls.getKey());
					Map<String, Integer> computerTypes = userDtls.getValue().stream()
							.filter(e -> e.getComputerType() != null).map(UserLicense::getComputerType)
							.map(String::toUpperCase)
							.collect(Collectors.groupingBy(e -> e, Collectors.summingInt(x -> 1)));
					logger.trace("Machine details :: {}", computerTypes);
					int noOfLicenseReq = UserLicenseUtils.getLicenseCout(computerTypes);
					appList.put("nooflicense", noOfLicenseReq);
					licList.add(appList);
				}
				result.put("license", licList);
				resultList.add(result);
			}

			return resultList;

		}

		return List.of();
	}

}
