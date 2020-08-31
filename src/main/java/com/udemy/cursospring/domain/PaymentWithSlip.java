package com.udemy.cursospring.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.udemy.cursospring.domain.enums.PaymentStatus;

@Entity
public class PaymentWithSlip extends Payment {

	private static final long serialVersionUID = 1L;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dueDate;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date paymentDate;

	public PaymentWithSlip() {

	}	

	public PaymentWithSlip(Integer id, PaymentStatus paymentStatus, Request request,Date dueDate, Date paymentDate) {
		super(id, paymentStatus, request);
		this.dueDate = dueDate;
		this.paymentDate = paymentDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

}
