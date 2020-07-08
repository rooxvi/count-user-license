package com.ciso.countlicense.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ciso.countlicense.exception.Errors;
import com.ciso.countlicense.exception.UserNotFoundException;
import com.ciso.countlicense.service.UserLicenseService;

@RestController
public class UserLicenseController {

	@Autowired
	private UserLicenseService userLicenseService;

	@GetMapping("/user/{userId}")
	public ResponseEntity<Map<String, Object>> getUserLicense(
			@PathVariable(name = "userId", required = true) Long userId) throws UserNotFoundException {

		Map<String, Object> body = userLicenseService.getUserLicenseDetails(userId);

		if (body.isEmpty()) {
			throw new UserNotFoundException(Errors.USERNOTFOUND);
		}

		return new ResponseEntity<>(body, HttpStatus.OK);
	}

	@GetMapping("/user/all")
	public ResponseEntity<List<Map<String, Object>>> getAllUserLicense() throws UserNotFoundException {

		List<Map<String, Object>> body = userLicenseService.getAllUserLicenseDetails();

		if (body.isEmpty()) {
			throw new UserNotFoundException(Errors.USERNOTFOUND);
		}

		return new ResponseEntity<>(body, HttpStatus.OK);
	}
}
