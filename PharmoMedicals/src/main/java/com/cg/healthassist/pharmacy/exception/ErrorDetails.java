package com.cg.healthassist.pharmacy.exception;

import java.util.Date;

/** The ErrorDetails layer provides Exceptions for timestamp,message,details
 * 
 * @author Rohith
 * @version 2.0
 * 
 */
public class ErrorDetails {
	private Date timestamp;
	private String message;
	private String details;

	public ErrorDetails(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
}
