package com.day.myblog.dto;

import org.springframework.http.HttpStatus;

public class ResponseDto<T> {
	int status;
	T data;
	
	public ResponseDto() {
		super();
	}

	public ResponseDto(int status, T data) {
		super();
		this.status = status;
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseDto [status=" + status + ", data=" + data + "]";
	}
	
}
