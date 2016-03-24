package com.travelbest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "routes")
public class Route {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;

	private String destination;

	private String description;

	private String image;

	public Route() {

	}

	public Route(long id, String destination, String description, String image) {
		setId(id);
		setDestination(destination);
		setDescription(description);
		setImage(image);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return String.format("id: %d, image: %s, destination: %s, description: %s", getId(), getImage(),
				getDestination(), getDescription());
	}

}
