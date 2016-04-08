package com.travelbest.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;

	@OneToOne
	@JoinColumn(name = "trip_id")
	private Trip trip;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToOne
	@JoinColumn(name = "payment_system_id")
	private PaymentSystem paymentSystem;

	@Column(name = "pay_date")
	private Date payDate;

	private boolean rejected;
	private boolean returned;

	public Order() {
	}

	public Order(Trip trip, User user, PaymentSystem paymentSystem, Date payDate,
			boolean rejected, boolean returned) {
		setTrip(trip);
		setUser(user);
		setPaymentSystem(paymentSystem);
		setPayDate(payDate);
		setRejected(rejected);
		setRejected(rejected);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PaymentSystem getPaymentSystem() {
		return paymentSystem;
	}

	public void setPaymentSystem(PaymentSystem paymentSystem) {
		this.paymentSystem = paymentSystem;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public boolean isRejected() {
		return rejected;
	}

	public void setRejected(boolean rejected) {
		this.rejected = rejected;
	}

	public boolean isReturned() {
		return returned;
	}

	public void setReturned(boolean returned) {
		this.returned = returned;
	}

	public String toString() {
		return String.format(
				"id: %d, trip_id: %d, user_id: %d, payment_system_id: %d," + "date: %s, rejected: %b, returned: %b",
				getId(), getTrip().getId(), getUser().getId(), getPaymentSystem().getId(), getPayDate().toString(),
				isRejected(), isReturned());
	}

}
