package com.mtag.traffic.sender;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.mtag.traffic.connection.Connector;
import com.mtag.traffic.model.TrafficData;
import com.mtag.traffic.util.JsonToTrafficUtil;

public class SendRequestToService implements Runnable {

	private ResponseListener listener;
	private String text;

	public SendRequestToService(ResponseListener listener) {
		this.listener = listener;
	}

	@Override
	public void run() {
		if (listener != null) {
			Connector connector = new Connector();
			InputStream in = connector.getInputStream(text);
			if (in != null) {
				BufferedReader reader = null;
				try {

					reader = new BufferedReader(new InputStreamReader(in));
					String line = reader.readLine();
					if (line != null && !line.isEmpty()) {
						TrafficData dataFromJson = JsonToTrafficUtil
								.getTrafficDataFromJson(line);
						listener.result(dataFromJson);
					}
				} catch (Exception e) {
					e.printStackTrace();
					listener.result(null);
				} finally {
					if (reader != null) {
						try {
							reader.close();
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}
				}
			}
		}
	}

	public void send(String text) {
		this.text = text;
		new Thread(this).start();
	}
}
