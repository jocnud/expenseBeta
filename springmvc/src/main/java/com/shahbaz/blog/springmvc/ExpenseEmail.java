package com.shahbaz.blog.springmvc;

import java.beans.Transient;
import java.io.Serializable;

public class ExpenseEmail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1580782828526939269L;

	
	public String from;

	public String subject;

	public String sentDate;

	public String receivedDate;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSentDate() {
		return sentDate;
	}

	public void setSentDate(String sentDate) {
		this.sentDate = sentDate;
	}

	public String getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(String receivedDate) {
		this.receivedDate = receivedDate;
	}

}
