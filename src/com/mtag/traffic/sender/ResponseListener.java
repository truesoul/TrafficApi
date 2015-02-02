package com.mtag.traffic.sender;

import com.mtag.traffic.model.TrafficData;

public interface ResponseListener {
	void result(TrafficData data);
}
