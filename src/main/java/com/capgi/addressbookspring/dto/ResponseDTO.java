package com.capgi.addressbookspring.dto;

import lombok.Data;

public @Data class ResponseDTO {
	private String message;
	private Object data;

	public ResponseDTO(String string, Object data) {
		this.message = string;
		this.data = data;
	}
}
