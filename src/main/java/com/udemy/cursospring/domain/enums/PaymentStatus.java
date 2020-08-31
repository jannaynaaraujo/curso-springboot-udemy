package com.udemy.cursospring.domain.enums;

public enum PaymentStatus {

	PENDING(1, "Pending"), SETTLED(2, "Settled"), CANCELED(3, "Canceled");

	private Integer code;
	private String value;

	private PaymentStatus(Integer code, String value) {
		this.code = code;
		this.value = value;
	}
	
	public Integer getCode() {
		return code;
	}

	public String getValue() {
		return value;
	}

	public static PaymentStatus toEnum(Integer code) {
		if(code == null) {
			return null;
		}
		
		for (PaymentStatus status : PaymentStatus.values()) {
			if(status.getCode().equals(code)) {
				return status;
			}
		}
		
		throw new IllegalArgumentException("Invalid code: " + code);
	}

}
