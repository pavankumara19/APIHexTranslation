package com.example.APIHexTranslation.model;

import java.util.Map;

public class Data {

	private String name;
	private String type;
	private int from;
	private int to;
	private String[] details;
	private Map<Integer, Data> child;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public String[] getDetails() {
		return details;
	}

	public void setDetails(String[] details) {
		this.details = details;
	}

	public Map<Integer, Data> getChild() {
		return child;
	}

	public void setChild(Map<Integer, Data> child) {
		this.child = child;
	}
}
