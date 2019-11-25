package com.example.demo;

public class CurrencyConversionBean {
	private Double convertedAmount;
	private Double conversionFactor;
	private int port;

	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}

	public CurrencyConversionBean() {

	}

	/**
	 * @return the conversionFactor
	 */
	public Double getConversionFactor() {
		return conversionFactor;
	}

	/**
	 * @param conversionFactor the conversionFactor to set
	 */
	public void setConversionFactor(Double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	/**
	 * @return the convertedAmount
	 */
	public Double getConvertedAmount() {
		return convertedAmount;
	}

	/**
	 * @param convertedAmount the convertedAmount to set
	 */
	public void setConvertedAmount(Double convertedAmount) {
		this.convertedAmount = convertedAmount;
	}

	public CurrencyConversionBean(Double conversionFactor, Double convertedAmount, int port) {
		this.conversionFactor = conversionFactor;
		this.convertedAmount = convertedAmount;
		this.port = port;
	}

	public CurrencyConversionBean(Double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}
}