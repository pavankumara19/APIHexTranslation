package com.example.APIHexTranslation.service;

import com.example.APIHexTranslation.model.Data;
import com.example.APIHexTranslation.model.RequestData;
import com.example.APIHexTranslation.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service public class HexTranslationService {

	public Map<String, Object> getParsedObject(RequestData requestData) {
		Map<String, Map<Integer, Data>> data = Utils.prepareContent();
		Map<String, Object> response = new HashMap<>();
		Map<Integer, Data> hexValue = data.get(requestData.getKey());
		String hexEncodedString = requestData.getValue();//02
		String[] tokens = hexEncodedString.split("(?<=\\G.{2})");
		for (int i = 0; i < tokens.length; i++) {
			if (hexValue.containsKey(i)) {
				Data dataObject = hexValue.get(i);
				StringBuilder sb = new StringBuilder();
				for (int j = dataObject.getFrom(); j <= dataObject
						.getTo(); j++) {
					String[] subTokens = tokens[j].split("");
					sb.append(hexToBin(subTokens[0]));
					sb.append(hexToBin(subTokens[1]));
				}
				int position = Integer.parseInt(sb.toString(), 2);
				if (dataObject.getChild().size() > 0) {
					position = Integer
							.parseInt(String.valueOf(sb.charAt(8 - position)));
					response.put(dataObject.getName(),
							dataObject.getChild().get(position).getName());
				} else {
					if (dataObject.getType().equals("enum")) {
						response.put(dataObject.getName(),
								dataObject.getDetails()[position]);
					} else {
						response.put(dataObject.getName(), position);
					}
				}
			}

		}
		return response;
	}

	private static String hexToBin(String hex) {
		hex = hex.replaceAll("0", "0000");
		hex = hex.replaceAll("1", "0001");
		hex = hex.replaceAll("2", "0010");
		hex = hex.replaceAll("3", "0011");
		hex = hex.replaceAll("4", "0100");
		hex = hex.replaceAll("5", "0101");
		hex = hex.replaceAll("6", "0110");
		hex = hex.replaceAll("7", "0111");
		hex = hex.replaceAll("8", "1000");
		hex = hex.replaceAll("9", "1001");
		hex = hex.replaceAll("A", "1010");
		hex = hex.replaceAll("B", "1011");
		hex = hex.replaceAll("C", "1100");
		hex = hex.replaceAll("D", "1101");
		hex = hex.replaceAll("E", "1110");
		hex = hex.replaceAll("F", "1111");
		return hex;
	}
}
