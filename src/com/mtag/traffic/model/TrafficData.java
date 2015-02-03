package com.mtag.traffic.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TrafficData implements Serializable {

    private static final long serialVersionUID = -2890714029177142785L;

    private long lastUpdated = 0;
    private final Queue<TrafficItem> trafficItems;
    private String copyright;
    private String errorMessage;

    public TrafficData(Exception ex) {
        this();
        this.errorMessage = ex.getMessage();
    }

    public TrafficData() {
        this.errorMessage = "";
        this.trafficItems = new PriorityQueue<>();
    }

    public long getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public List<TrafficItem> getTrafficItems() {
        return new ArrayList<>(this.trafficItems);
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

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("TrafficData{" + "lastUpdated=" + lastUpdated
                + ", trafficItems={");
        for (TrafficItem item : trafficItems) {
            result.append("\n" + item);
        }
        return result.append("}}").toString();
    }

}
