package com.nearsoft.task;

public class MessageFromSender {

	private String message;
	private String receiver;
	
	
	
	public MessageFromSender(String message, String receiver) {
		super();
		this.message = message;
		this.receiver = receiver;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	
	
	
}
