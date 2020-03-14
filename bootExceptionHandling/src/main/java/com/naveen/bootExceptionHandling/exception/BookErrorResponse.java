package com.naveen.bootExceptionHandling.exception;

import java.time.LocalDateTime;
import java.util.List;

public class BookErrorResponse {
	
	private LocalDateTime timestamp;
	private List<String> error;
	private Integer status;

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public List<String> getError() {
		return error;
	}

	public void setError(List<String> error) {
		this.error = error;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
