package com.udemy.cursospring.domain.enums;

public enum ClientType {

	PHYSICAL_PERSON(1, "Physical person"), LEGAL_PERSON(2, "Legal person");

	private Integer code;
	private String value;

	private ClientType(Integer code, String value) {
		this.code = code;
		this.value = value;
	}

	public Integer getCode() {
		return code;
	}

	public String getValue() {
		return value;
	}

	public static ClientType toEnum(Integer code) {
		if (code == null) {
			return null;
		}

		for (ClientType type : ClientType.values()) {
			if (code.equals(type.getCode()))
				return type;
		}

		throw new IllegalArgumentException("Invalid code: " + code);
	}

}
