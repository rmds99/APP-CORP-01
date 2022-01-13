package com.imposto_de_renda.controller.exceptions;

import java.time.LocalDateTime;

public class StanderError 
{
	private LocalDateTime timestamp;
	private String error;
	private String path;
	private Integer status;
	
	
	
	
	public StanderError(LocalDateTime timestamp, String error, String path, Integer status) 
	{
		super();
		this.timestamp = timestamp;
		this.error = error;
		this.path = path;
		this.status = status;
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
