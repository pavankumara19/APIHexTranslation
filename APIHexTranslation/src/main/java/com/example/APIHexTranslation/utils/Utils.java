package com.example.APIHexTranslation.utils;

import com.example.APIHexTranslation.model.Data;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Utils {
	public static Map<String, Map<Integer, Data>> prepareContent() {
		Map<String, Map<Integer, Data>> map = new HashMap<String, Map<Integer, Data>>();
		map.put("0000001", prepareFirstObj());
		map.put("0000002", prepareSecondObj());
		map.put("0000004", prepareThirdObj());

		return map;
	}

	private static Map<Integer, Data> prepareThirdObj() {
		Map<Integer, Data> map = new HashMap<Integer, Data>();

		map.put(0, prepareDataObject("shade", "int", new String[0], 0, 0,
				Collections.EMPTY_MAP));
		map.put(1, prepareDataObject("size", "enum",
				new String[] { "Small", "Medium", "Large" }, 1, 1,
				Collections.EMPTY_MAP));
		map.put(2, prepareDataObject("temperature", "int",
				new String[] { "Small", "Medium", "Large" }, 2, 3,
				Collections.EMPTY_MAP));

		map.put(4,
				prepareDataObject("cook_time(Seconds)", "int", new String[0], 4,
						7, Collections.EMPTY_MAP));
		map.put(8, prepareDataObject("count", "int", new String[0], 8, 8,
				Collections.EMPTY_MAP));
		String[] array = new String[] { "Air Fry", "Bake", "Broil", "Roast",
				"Reheat", "Warm", "Slow Cook", "Dehydrate", "Proof", "Cookie",
				"Pizza", "Bagel", "Toast", "Crisp Finish", "Cake",
				"Cookie with Preference", "Pizza with Preference" };
		map.put(9, prepareDataObject("cook_mode", "enum", array, 9, 9,
				Collections.EMPTY_MAP));
		map.put(10, prepareDataObject("preferences", "int", new String[0], 10, 10,
				Collections.EMPTY_MAP));

		return map;
	}

	private static Map<Integer, Data> prepareSecondObj() {
		Map<Integer, Data> map = new HashMap<Integer, Data>();

		Map<Integer, Data> childMap = new HashMap<Integer, Data>();

		childMap.put(0, prepareDataObject("Target Temperature Achieved", "bit",
				new String[0], 0, 0, Collections.EMPTY_MAP));
		childMap.put(1,
				prepareDataObject("Cooking Started", "bit", new String[0], 1, 1,
						Collections.EMPTY_MAP));
		childMap.put(2,
				prepareDataObject("Cooktime One Minute Remaining", "bit",
						new String[0], 2, 2, Collections.EMPTY_MAP));
		childMap.put(3,
				prepareDataObject("Cooking Complete", "bit", new String[0], 3,
						3, Collections.EMPTY_MAP));

		map.put(0, prepareDataObject("cooking_notifications", "", new String[0], 0, 0, childMap));
		return map;
	}

	private static Data prepareDataObject(String name, String type,
			String[] details, int from, int to, Map<Integer, Data> childMap) {
		Data data = new Data();
		data.setName(name);
		data.setDetails(details);
		data.setFrom(from);
		data.setTo(to);
		data.setType(type);
		data.setChild(childMap);
		return data;
	}

	private static Map<Integer, Data> prepareFirstObj() {
		Map<Integer, Data> map = new HashMap<Integer, Data>();
		map.put(0, prepareDataObject("door_status", "enum",
				new String[] { "Closed", "Open" }, 0, 0,
				Collections.EMPTY_MAP));
		return map;
	}

}

