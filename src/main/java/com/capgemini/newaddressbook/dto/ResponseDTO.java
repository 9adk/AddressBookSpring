package com.capgemini.newaddressbook.dto;
public class ResponseDTO {
	private String message;
	private Object obj;
	public ResponseDTO(String message, Object obj) {
		super();
		this.message = message;
		this.obj = obj;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}	
}
