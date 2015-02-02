package com.mtag.traffic.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.mtag.traffic.model.TrafficData;
import com.mtag.traffic.model.TrafficItem;
import com.mtag.traffic.model.TrafficType;
import com.mtag.traffic.tokens.JsonTokens;


public class JsonToTrafficUtil {

	public static TrafficData getTrafficDataFromJson(String text) {
		JSONParser parser = new JSONParser();
		TrafficData data = new TrafficData();
		try {
			JSONObject parse = (JSONObject) parser.parse(text);
			if (parse != null) {
				data.setLastUpdated(JsonTools.requestLong(parse,
						JsonTokens.LAST_UPDATED));
				data.setCopyright(JsonTools.requestString(parse,
						JsonTokens.COPYRIGHT));
				Object list = JsonTools.requestPath(parse,
						JsonTokens.TRAFFIC_ITEMS);
				if (list instanceof JSONArray) {
					JSONArray array = (JSONArray) list;
					for (int i = 0; i < array.size(); i++) {
						JSONObject object = (JSONObject) array.get(i);
						TrafficItem item = new TrafficItem();

						item.setStreet(JsonTools.requestString(object,
								JsonTokens.STREET));
						item.setDirection(JsonTools.requestString(object,
								JsonTokens.DIRECTION));
						item.setDescription(JsonTools.requestString(object,
								JsonTokens.DESCRIPTION));
						item.setType(TrafficType.valueOf(JsonTools
								.requestString(object, JsonTokens.TYPE)));
						item.setKilometer(JsonTools.requestInteger(object,
								JsonTokens.KILOMETER));
						item.setDelayMinutes(JsonTools.requestInteger(object,
								JsonTokens.DELAYMINUTES));
						item.setLatitude(JsonTools.requestDouble(object,
								JsonTokens.LATITUDE));
						item.setLongitude(JsonTools.requestDouble(object,
								JsonTokens.LONGITUDE));
						item.setState(JsonTools.requestString(object,
								JsonTokens.STATE));
						data.addTrafficItem(item);
					}
				} else {
					data = null;
				}
			} else {
				data = null;
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return data;
	}
}
