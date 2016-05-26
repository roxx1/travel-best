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
@Table(name = "trips")
public class Trip {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;

	@OneToOne
	@JoinColumn(name = "route_id")
	private Route route;

	@OneToOne
	@JoinColumn(name = "guide_id")
	private Guide guide;

	@Column(name = "price")
	private double price;

	@Column(name = "expiration_date")
	private Date expirationDate;

	@Column(name = "trip_start_date")
	private Date tripStartDate;

	@Column(name = "trip_end_date")
	private Date tripEndDate;

	@Column(name = "amount_of_tourists")
	private int amountOfTourists;

	@Column(name = "min_amount_of_tourists")
	private int minAmountOfTourists;

	@Column(name = "max_amount_of_tourists")
	private int maxAmountOfTourits;

	@Column(name = "inssurance_sum")
	private double inssuranceSum;

	public Trip() {

	}

	public Trip(long id, Route route, Guide guide, double price, Date expirationDate, Date tripStartDate,
			Date tripEndDate, int amountOfTourists, int minAmountOfTourists, int maxAmountOfTourits,
			double inssuranceSum) {

		setId(id);
		setRoute(route);
		setGuide(guide);
		setPrice(price);
		setExpirationDate(expirationDate);
		setTripStartDate(tripStartDate);
		setTripEndDate(tripEndDate);
		setAmountOfTourists(amountOfTourists);
		setMinAmountOfTourists(minAmountOfTourists);
		setMaxAmountOfTourits(maxAmountOfTourits);
		setInssuranceSum(inssuranceSum);

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Guide getGuide() {
		return guide;
	}

	public void setGuide(Guide guide) {
		this.guide = guide;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Date getTripStartDate() {
		return tripStartDate;
	}

	public void setTripStartDate(Date tripStartDate) {
		this.tripStartDate = tripStartDate;
	}

	public Date getTripEndDate() {
		return tripEndDate;
	}

	public void setTripEndDate(Date tripEndDate) {
		this.tripEndDate = tripEndDate;
	}

	public int getAmountOfTourists() {
		return amountOfTourists;
	}

	public void setAmountOfTourists(int amountOfTourists) {
		this.amountOfTourists = amountOfTourists;
	}

	public int getMinAmountOfTourists() {
		return minAmountOfTourists;
	}

	public void setMinAmountOfTourists(int minAmountOfTourists) {
		this.minAmountOfTourists = minAmountOfTourists;
	}

	public int getMaxAmountOfTourits() {
		return maxAmountOfTourits;
	}

	public void setMaxAmountOfTourits(int maxAmountOfTourits) {
		this.maxAmountOfTourits = maxAmountOfTourits;
	}

	public double getInssuranceSum() {
		return inssuranceSum;
	}

	public void setInssuranceSum(double inssuranceSum) {
		this.inssuranceSum = inssuranceSum;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amountOfTourists;
		result = prime * result + ((expirationDate == null) ? 0 : expirationDate.hashCode());
		result = prime * result + ((guide == null) ? 0 : guide.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		long temp;
		temp = Double.doubleToLongBits(inssuranceSum);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + maxAmountOfTourits;
		result = prime * result + minAmountOfTourists;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((route == null) ? 0 : route.hashCode());
		result = prime * result + ((tripEndDate == null) ? 0 : tripEndDate.hashCode());
		result = prime * result + ((tripStartDate == null) ? 0 : tripStartDate.hashCode());
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
		Trip other = (Trip) obj;
		if (amountOfTourists != other.amountOfTourists)
			return false;
		if (expirationDate == null) {
			if (other.expirationDate != null)
				return false;
		} else if (!expirationDate.equals(other.expirationDate))
			return false;
		if (guide == null) {
			if (other.guide != null)
				return false;
		} else if (!guide.equals(other.guide))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(inssuranceSum) != Double.doubleToLongBits(other.inssuranceSum))
			return false;
		if (maxAmountOfTourits != other.maxAmountOfTourits)
			return false;
		if (minAmountOfTourists != other.minAmountOfTourists)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (route == null) {
			if (other.route != null)
				return false;
		} else if (!route.equals(other.route))
			return false;
		if (tripEndDate == null) {
			if (other.tripEndDate != null)
				return false;
		} else if (!tripEndDate.equals(other.tripEndDate))
			return false;
		if (tripStartDate == null) {
			if (other.tripStartDate != null)
				return false;
		} else if (!tripStartDate.equals(other.tripStartDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"id: %d, route_id: %d, guide_id: %d, price: %.2f"
						+ "expiration_date: %s, trip_start_date: %s, trip_end_date: %s,"
						+ "amount_of_tourists: %d, max_amount_of_tourists: %d, min_amount_of_tourists: %d,"
						+ "inssurance_sum: %.2f",
				getId(), getRoute().getId(), getGuide().getId(), getPrice(),
				getExpirationDate().toString(), getTripStartDate().toString(), getTripEndDate().toString(),
				getAmountOfTourists(), getMaxAmountOfTourits(), getMinAmountOfTourists(),
				getInssuranceSum());
	}

}
