/* 
  Licensed to the Apache Software Foundation (ASF) under one or more
  contributor license agreements.  See the NOTICE file distributed with
  this work for additional information regarding copyright ownership.
  The ASF licenses this file to You under the Apache License, Version 2.0
  (the "License"); you may not use this file except in compliance with
  the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
 */
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
