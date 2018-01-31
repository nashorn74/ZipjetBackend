package org.nashorn.zipjet;

public class Currency {
	private String baseCurrency;
	private Double baseAmount;
	private String targetCurrency;
	private Double targetAmount;
	private Integer errorCode;
	
	protected Currency() {}
	
	public Currency(String baseCurrency, Double baseAmount, String targetCurrency, Double targetAmount) {
		this.baseCurrency = baseCurrency;
		this.baseAmount = baseAmount;
		this.targetCurrency = targetCurrency;
		this.targetAmount = targetAmount;
		this.errorCode = 0;
	}

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public Double getBaseAmount() {
		return baseAmount;
	}

	public void setBaseAmount(Double baseAmount) {
		this.baseAmount = baseAmount;
	}

	public String getTargetCurrency() {
		return targetCurrency;
	}

	public void setTargetCurrency(String targetCurrency) {
		this.targetCurrency = targetCurrency;
	}

	public Double getTargetAmount() {
		return targetAmount;
	}

	public void setTargetAmount(Double targetAmount) {
		this.targetAmount = targetAmount;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
}
