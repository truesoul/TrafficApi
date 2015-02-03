package com.mtag.traffic.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author christian
 */
public class TrafficData implements Serializable {

	private static final long serialVersionUID = 3202171319169344072L;

	private long lastUpdated;
	private final List<TrafficItem> trafficItems;
	private String copyright;
	private String errorMessage;

	public TrafficData() {
		lastUpdated = 0;
		copyright = "";
		this.trafficItems = new ArrayList<>();
		errorMessage = "";
	}

	public TrafficData(Exception ex) {
		this();
		errorMessage = ex.getClass().getName() + ": " + ex.getMessage();
	}

	public long getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(long lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public List<TrafficItem> getTrafficItems() {
		return this.trafficItems;
	}

	public void addTrafficItem(TrafficItem trafficItem) {
		this.trafficItems.add(trafficItem);
	}

	public int getCount() {
		return this.trafficItems.size();
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	@Override
	public String toString() {
		String result = "TrafficData{" + "lastUpdated=" + lastUpdated
				+ ", trafficItems={";
		for (TrafficItem item : trafficItems) {
			result += "\n" + item;
		}
		return result + "}}";
	}

}
