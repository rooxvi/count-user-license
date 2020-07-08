package com.ciso.countlicense.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciso.countlicense.entity.UserLicense;

@Repository
public interface UserLicenseRepository extends JpaRepository<UserLicense, Long> {
	Optional<List<UserLicense>> findByUserId(Long userId);
	List<UserLicense> findAll();
}
