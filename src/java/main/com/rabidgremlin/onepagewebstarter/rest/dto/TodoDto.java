package com.rabidgremlin.onepagewebstarter.rest.dto;

import org.joda.time.DateTime;

public class TodoDto
{

  private String id;
  private String description;
  private Boolean completed;
  private DateTime lastDateTimeModified;

  public TodoDto()
  {
	// do nothing
  }

  public TodoDto(String id, String description, Boolean completed, DateTime lastDateTimeModified)
  {
	this.id = id;
	this.description = description;
	this.completed = completed;
	this.lastDateTimeModified = lastDateTimeModified;
  }

  public String getId()
  {
	return id;
  }

  public void setId(String id)
  {
	this.id = id;
  }

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

  public DateTime getLastDateTimeModified()
  {
	return lastDateTimeModified;
  }

  public void setLastDateTimeModified(DateTime lastDateTimeModified)
  {
	this.lastDateTimeModified = lastDateTimeModified;
  }

  @Override
  public String toString()
  {
	return "TodoDto [id=" + id + ", description=" + description + ", completed=" + completed + ", lastDateTimeModified="
	    + lastDateTimeModified + "]";
  }

}
