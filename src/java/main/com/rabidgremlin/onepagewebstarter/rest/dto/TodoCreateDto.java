package com.rabidgremlin.onepagewebstarter.rest.dto;


public class TodoCreateDto {

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "TodoCreateDto [description=" + description + "]";
	}

}
