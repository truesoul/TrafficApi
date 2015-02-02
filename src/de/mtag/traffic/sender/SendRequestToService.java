package de.mtag.traffic.sender;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import de.mtag.traffic.connection.Connector;
import de.mtag.traffic.model.TrafficData;
import de.mtag.traffic.util.JsonToTrafficUtil;

public class SendRequestToService implements Runnable {

	private ResponseListener listener;
	private String text;

	public SendRequestToService(ResponseListener listener) {
		this.listener = listener;
	}

	@Override
	public void run() {
		Connector connector = new Connector();
		InputStream in = connector.getInputStream(text);
		if (in != null) {
			BufferedReader reader = null;
			try {

				reader = new BufferedReader(new InputStreamReader(in));
				String line = null;
				StringBuilder builder = new StringBuilder();
				while ((line = reader.readLine()) != null) {
					builder.append(line);
				}
				TrafficData dataFromJson = JsonToTrafficUtil
						.getTrafficDataFromJson(builder.toString());
				if (listener != null)
					listener.result(dataFromJson);
			} catch (Exception e) {
				e.printStackTrace();
				if (listener != null)
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

	public void send(String text) {
		this.text = text;
		new Thread(this).start();
	}
}
