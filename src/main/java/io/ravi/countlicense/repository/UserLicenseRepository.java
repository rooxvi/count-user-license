package io.ravi.countlicense.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.ravi.countlicense.entity.UserLicense;

@Repository
public interface UserLicenseRepository extends JpaRepository<UserLicense, Long> {
	Optional<List<UserLicense>> findByUserId(Long userId);
	List<UserLicense> findAll();
}
