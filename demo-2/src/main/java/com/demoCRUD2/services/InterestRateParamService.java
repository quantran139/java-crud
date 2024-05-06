package com.demoCRUD2.services;

import java.util.List;
import java.util.Optional;

import com.demoCRUD2.models.InterestRateParam;

import DTO.InterestRateParamDTO;

public interface InterestRateParamService {
	List<InterestRateParamDTO> getAllWithValue();

	Boolean create(InterestRateParam interestRateParam);

	Boolean update(InterestRateParam interestRateParam);

	Boolean delete(Integer id);

	Optional<InterestRateParam> findById(Integer id);

	List<InterestRateParam> getTheList();

	Boolean existsByInterestRateParamName(String interestRateParamName);

	Boolean existsByInterestRateParamNameAndIdNot(String interestRateParamName, Long id);
}
