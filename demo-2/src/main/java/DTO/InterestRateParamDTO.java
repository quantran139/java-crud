package DTO;

public class InterestRateParamDTO {

	private Long id;
	private String interestRateParamName;
	private Boolean interestRateParamStatus;
	private String interestRateParamNote;
	private Double interestRateParamValue;

	public InterestRateParamDTO() {

	}

	public InterestRateParamDTO(Long id, String interestRateParamName, Boolean interestRateParamStatus,
			String interestRateParamNote, Double interestRateParamValue) {
		super();
		this.id = id;
		this.interestRateParamName = interestRateParamName;
		this.interestRateParamStatus = interestRateParamStatus;
		this.interestRateParamNote = interestRateParamNote;
		this.interestRateParamValue = interestRateParamValue;
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

	public Double getInterestRateParamValue() {
		return interestRateParamValue;
	}

	public void setInterestRateParamValue(Double interestRateParamValue) {
		this.interestRateParamValue = interestRateParamValue;
	}

}
