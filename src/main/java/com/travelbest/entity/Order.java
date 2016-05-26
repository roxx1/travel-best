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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((payDate == null) ? 0 : payDate.hashCode());
		result = prime * result + ((paymentSystem == null) ? 0 : paymentSystem.hashCode());
		result = prime * result + (rejected ? 1231 : 1237);
		result = prime * result + (returned ? 1231 : 1237);
		result = prime * result + ((trip == null) ? 0 : trip.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id != other.id)
			return false;
		if (payDate == null) {
			if (other.payDate != null)
				return false;
		} else if (!payDate.equals(other.payDate))
			return false;
		if (paymentSystem == null) {
			if (other.paymentSystem != null)
				return false;
		} else if (!paymentSystem.equals(other.paymentSystem))
			return false;
		if (rejected != other.rejected)
			return false;
		if (returned != other.returned)
			return false;
		if (trip == null) {
			if (other.trip != null)
				return false;
		} else if (!trip.equals(other.trip))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	public String toString() {
		return String.format(
				"id: %d, trip_id: %d, user_id: %d, payment_system_id: %d," + "date: %s, rejected: %b, returned: %b",
				getId(), getTrip().getId(), getUser().getId(), getPaymentSystem().getId(), getPayDate().toString(),
				isRejected(), isReturned());
	}

}
