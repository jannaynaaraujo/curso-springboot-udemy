package com.udemy.cursospring.domain;

import javax.persistence.Entity;

import com.udemy.cursospring.domain.enums.PaymentStatus;

@Entity
public class PaymentWithCard extends Payment {

	private static final long serialVersionUID = 1L;

	private Integer installments;

	public PaymentWithCard() {

	}

	public PaymentWithCard(Integer id, PaymentStatus paymentStatus, Request request, Integer installments) {
		super(id, paymentStatus, request);
		this.installments = installments;
	}

	public Integer getInstallments() {
		return installments;
	}

	public void setInstallments(Integer installments) {
		this.installments = installments;
	}

}
