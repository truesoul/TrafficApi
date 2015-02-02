package de.mtag.traffic.connection;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Connector {

	private final static String URL = "http://192.168.15.153:8080/restTrafficService";

	public InputStream getInputStream(String... text) {

		if (text != null) {
			StringBuilder allParams = createParams(Arrays.asList(text));

			if (allParams != null) {
				HttpURLConnection urlConnection = null;
				try {
					URL url = getUrl(allParams.toString());
					if (url != null) {
						urlConnection = (HttpURLConnection) url
								.openConnection();
						urlConnection.setReadTimeout(10000);
						urlConnection.setConnectTimeout(10000);
						urlConnection.setDoOutput(true);
						urlConnection.connect();
						InputStream in = new BufferedInputStream(
								urlConnection.getInputStream());
						return in;
					}
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	private StringBuilder createParams(List<String> list) {
		StringBuilder builder = new StringBuilder();
		Iterator<String> iterator = list.iterator();

		while (iterator.hasNext()) {
			String next = iterator.next();
			builder.append(next.replaceAll(" ", "%20"));
			if (iterator.hasNext()) {
				builder.append(", ");
			}
		}
		return builder;
	}

	private URL getUrl(String params) throws MalformedURLException {
		return new URL(URL + (params.isEmpty() ? "" : "?userInput=" + params));
	}
}
