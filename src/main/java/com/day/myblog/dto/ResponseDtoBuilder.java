package com.day.myblog.dto;

import org.springframework.http.HttpStatus;

public class ResponseDtoBuilder<T> {
	int status;
	T data;
	
	public ResponseDtoBuilder<T> setStatus(int status) {
		this.status = status;
		return this;
	}
	public ResponseDtoBuilder<T> setData(T data) {
		this.data = data;
		return this;
	}

	public ResponseDto<T> build() {
		return new ResponseDto<T>(status, data);
	}
	
}
