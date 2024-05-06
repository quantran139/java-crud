package com.demoCRUD2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demoCRUD2.models.InterestRateParam;

public interface InterestRateParamRepository extends JpaRepository<InterestRateParam, Integer> {

	boolean existsByInterestRateParamName(String interestRateParamName);

	boolean existsByInterestRateParamNameAndIdNot(String interestRateParamName, Long id);

}
