package de.mtag.traffic.model;

import java.io.Serializable;

public class TrafficItem implements Serializable {

	private static final long serialVersionUID = 365503745315195851L;

	private String street;
	private String direction;
	private String description;
	private double longitude, altitude;
	private Integer kilometer;
	private String state;
	private TrafficType type;
	private int delayMinutes;

	public TrafficItem() {

	}

	public TrafficItem(String street, String direction, String description,
			double longitude, double altitude, Integer kilometer, String state,
			TrafficType type, int delayMinutes) {
		this.street = street;
		this.direction = direction;
		this.description = description;
		this.longitude = longitude;
		this.altitude = altitude;
		this.kilometer = kilometer;
		this.state = state;
		this.type = type;
		this.delayMinutes = delayMinutes;
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

	public double getAltitude() {
		return altitude;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
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

	@Override
	public String toString() {

		return "TrafficItem [street=" + street + ", direction=" + direction
				+ ", description=" + description + ", longitude=" + longitude
				+ ", altitude=" + altitude + ", kilometer=" + kilometer
				+ ", state=" + state + ", type=" + type + ", delayMinutes="
				+ delayMinutes + "]";
	}

}
