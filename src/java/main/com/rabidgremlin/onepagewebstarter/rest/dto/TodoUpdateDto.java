package com.rabidgremlin.onepagewebstarter.rest.dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TodoUpdateDto
{

  private String description;
  private Boolean completed;

  public String getDescription()
  {
	return description;
  }

  public void setDescription(String description)
  {
	this.description = description;
  }

  public Boolean getCompleted()
  {
	return completed;
  }

  public void setCompleted(Boolean completed)
  {
	this.completed = completed;
  }

  @Override
  public String toString()
  {
	return "TodoUpdateDto [description=" + description + ", completed=" + completed + "]";
  }

}
