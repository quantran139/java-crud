package com.demoCRUD2.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "interestRateParams")
public class InterestRateParam {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "interestRateParamName")

	private String interestRateParamName;

	@Column(name = "interestRateParamStatus")
	private Boolean interestRateParamStatus;

	@Column(name = "interestRateParamNote")

	private String interestRateParamNote;

	@OneToOne(mappedBy = "interestRateParam", cascade = CascadeType.ALL)
	private LaiSuat laiSuat;

	public InterestRateParam() {
	}

	public InterestRateParam(Long id, String interestRateParamName, Boolean interestRateParamStatus,
			String interestRateParamNote, LaiSuat laiSuat) {
		super();
		this.id = id;
		this.interestRateParamName = interestRateParamName;
		this.interestRateParamStatus = interestRateParamStatus;
		this.interestRateParamNote = interestRateParamNote;
		this.laiSuat = laiSuat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInterestRateParamName() {
		return interestRateParamName;
	}

	public void setInterestRateParamName(String interestRateParamName) {
		this.interestRateParamName = interestRateParamName;
	}

	public Boolean getInterestRateParamStatus() {
		return interestRateParamStatus;
	}

	public void setInterestRateParamStatus(Boolean interestRateParamStatus) {
		this.interestRateParamStatus = interestRateParamStatus;
	}

	public String getInterestRateParamNote() {
		return interestRateParamNote;
	}

	public void setInterestRateParamNote(String interestRateParamNote) {
		this.interestRateParamNote = interestRateParamNote;
	}

	public LaiSuat getLaiSuat() {
		return laiSuat;
	}

	public void setLaiSuat(LaiSuat laiSuat) {
		this.laiSuat = laiSuat;
	}

}
