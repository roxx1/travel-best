package com.travelbest.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name = "trips")
@Data
@NoArgsConstructor
public class Trip {

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne
	@JoinColumn(name = "route_id")
	private Route route;

	@OneToOne
	@JoinColumn(name = "guide_id")
	private Guide guide;

	@Column(name = "price")
    @NotNull
    @Min(0)
	private Double price;

	@Column(name = "expiration_date")
	private Date expirationDate;

	@Column(name = "trip_start_date")
	private Date tripStartDate;

	@Column(name = "trip_end_date")
	private Date tripEndDate;

	@Column(name = "amount_of_tourists")
	private Integer amountOfTourists;

	@Column(name = "min_amount_of_tourists")
	private Integer minAmountOfTourists;

	@Column(name = "max_amount_of_tourists")
	private Integer maxAmountOfTourits;

	@Column(name = "inssurance_sum")
	private Double inssuranceSum;

	public Trip(Route route, Double price) {
		this.setPrice(price);
		this.setRoute(route);
	}

}
