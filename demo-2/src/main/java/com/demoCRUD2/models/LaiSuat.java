package com.demoCRUD2.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "LaiSuat")
public class LaiSuat {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	@Column(name = "interestRateParamName")

	private String interestRateParamName;

	@Column(name = "interestRateParamValue")
	private Double interestRateParamValue;

	@Column(name = "branch")

	private String branch;

	@OneToOne
	@JoinColumn(name = "interestRateParam_id", referencedColumnName = "id")
	private InterestRateParam interestRateParam;

	public LaiSuat() {

	}

	public LaiSuat(Long id, String interestRateParamName, Double interestRateParamValue, String branch,
			InterestRateParam interestRateParam) {
		super();
		this.id = id;
		this.interestRateParamName = interestRateParamName;
		this.interestRateParamValue = interestRateParamValue;
		this.branch = branch;
		this.interestRateParam = interestRateParam;
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

	public Double getInterestRateParamValue() {
		return interestRateParamValue;
	}

	public void setInterestRateParamValue(Double interestRateParamValue) {
		this.interestRateParamValue = interestRateParamValue;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public InterestRateParam getInterestRateParam() {
		return interestRateParam;
	}

	public void setInterestRateParam(InterestRateParam interestRateParam) {
		this.interestRateParam = interestRateParam;
	}

}
