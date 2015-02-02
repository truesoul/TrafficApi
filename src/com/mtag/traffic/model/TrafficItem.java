package com.mtag.traffic.model;

import java.io.Serializable;

public class TrafficItem implements Serializable {

	private static final long serialVersionUID = 365503745315195851L;

	private String street;
	private String direction;
	private String description;
	private double longitude, latitude;
	private Integer kilometer;
	private String state;
	private TrafficType type;
	private int delayMinutes;
	private int maxSpeed;

	public TrafficItem() {
		this("", "", "", 0.0, 0.0, -1, "", TrafficType.NONE, -1, -1);
	}

	public TrafficItem(String street, String direction, String description,
			double longitude, double altitude, Integer kilometer, String state,
			TrafficType type, int delayMinutes, int maxSpeed) {
		this.street = street;
		this.direction = direction;
		this.description = description;
		this.longitude = longitude;
		this.latitude = altitude;
		this.kilometer = kilometer;
		this.state = state;
		this.type = type;
		this.delayMinutes = delayMinutes;
		this.maxSpeed = maxSpeed;
	}

	public TrafficType getType() {
		return type;
	}

	public void setType(TrafficType type) {
		this.type = type;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setKilometer(Integer kilometer) {
		this.kilometer = kilometer;
	}

	public Integer getKilometer() {
		return kilometer;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setDelayMinutes(int delayMinutes) {
		this.delayMinutes = delayMinutes;
	}

	public int getDelayMinutes() {
		return delayMinutes;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	@Override
	public String toString() {
		return "TrafficItem{" + "street=" + street + ", direction=" + direction
				+ ", description=" + description + ", longitude=" + longitude
				+ ", latitude=" + latitude + ", kilometer=" + kilometer
				+ ", state=" + state + ", type=" + type + ", delayMinutes="
				+ delayMinutes + ", maxSpeed=" + maxSpeed + '}';
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + delayMinutes;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((direction == null) ? 0 : direction.hashCode());
		result = prime * result
				+ ((kilometer == null) ? 0 : kilometer.hashCode());
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + maxSpeed;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		TrafficItem other = (TrafficItem) obj;
		if (delayMinutes != other.delayMinutes)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (direction == null) {
			if (other.direction != null)
				return false;
		} else if (!direction.equals(other.direction))
			return false;
		if (kilometer == null) {
			if (other.kilometer != null)
				return false;
		} else if (!kilometer.equals(other.kilometer))
			return false;
		if (Double.doubleToLongBits(latitude) != Double
				.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double
				.doubleToLongBits(other.longitude))
			return false;
		if (maxSpeed != other.maxSpeed)
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}
