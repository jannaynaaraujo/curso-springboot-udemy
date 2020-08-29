package com.udemy.cursospring.domain.enums;

public enum ClientType {
	
	PESSOA_FISICA(1, "Pessoa física"),
	PESSOA_JURIDICA(2, "Pessoas jurídica");
	
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
		if(code == null) {
			return null;
		}
		
		for (ClientType type : ClientType.values()) {
			if(code.equals(type))
				return type;
		}
		
		throw new IllegalArgumentException("Código inválido: " + code);
	}

}
