package de.mtag.traffic.sender;

import de.mtag.traffic.model.TrafficData;

public interface ResponseListener {
	void result(TrafficData data);
}
