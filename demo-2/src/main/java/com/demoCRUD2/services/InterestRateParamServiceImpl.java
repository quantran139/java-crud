package com.demoCRUD2.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoCRUD2.models.InterestRateParam;
import com.demoCRUD2.models.LaiSuat;
import com.demoCRUD2.repository.InterestRateParamRepository;

import DTO.InterestRateParamDTO;

@Service
public class InterestRateParamServiceImpl implements InterestRateParamService {
	@Autowired
	private InterestRateParamRepository interestRateParamRepository;

	@Override
	public List<InterestRateParamDTO> getAllWithValue() {
		List<InterestRateParam> interestRateParams = interestRateParamRepository.findAll();

		List<InterestRateParamDTO> dtos = new ArrayList<>();

		for (InterestRateParam irp : interestRateParams) {
			InterestRateParamDTO dto = convertToDTO(irp);
			dtos.add(dto);
		}

		return dtos;
	}

	private InterestRateParamDTO convertToDTO(InterestRateParam irp) {
		LaiSuat laiSuat = irp.getLaiSuat();
		Double interestRateParamValue = (laiSuat != null) ? laiSuat.getInterestRateParamValue() : null;
		return new InterestRateParamDTO(irp.getId(), irp.getInterestRateParamName(), irp.getInterestRateParamStatus(),
				irp.getInterestRateParamNote(), interestRateParamValue);
	}

	@Override
	public Boolean create(InterestRateParam interestRateParam) {
		// TODO Auto-generated method stub
		try {
			this.interestRateParamRepository.save(interestRateParam);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean update(InterestRateParam interestRateParam) {
		// TODO Auto-generated method stub
		try {
			this.interestRateParamRepository.save(interestRateParam);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean delete(Integer id) {
		// TODO Auto-generated method stub
		try {
			interestRateParamRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Optional<InterestRateParam> findById(Integer id) {
		// TODO Auto-generated method stub
		return interestRateParamRepository.findById(id);
	}

	@Override
	public List<InterestRateParam> getTheList() {
		// TODO Auto-generated method stub
		return interestRateParamRepository.findAll();
	}

	@Override
	public Boolean existsByInterestRateParamName(String interestRateParamName) {
		// TODO Auto-generated method stub
		return interestRateParamRepository.existsByInterestRateParamName(interestRateParamName);
	}

	@Override
	public Boolean existsByInterestRateParamNameAndIdNot(String interestRateParamName, Long id) {
		// TODO Auto-generated method stub
		return interestRateParamRepository.existsByInterestRateParamNameAndIdNot(interestRateParamName, id);
	}

}
