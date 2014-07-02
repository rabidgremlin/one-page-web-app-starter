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
package com.rabidgremlin.onepagewebstarter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.joda.time.DateTime;

// TODO look at using NamedQueries http://stackoverflow.com/questions/9793252/selecting-all-rows-from-a-database-using-jpa-in-websphere

@Entity
@Table(name = "todo")
public class Todo
{
  @Id
  @Column
  private String id;

  @Column
  private String description;

  @Column
  private Boolean completed;

  @Column
  @Version
  private DateTime lastDateTimeModified;

  public Boolean getCompleted()
  {
	return completed;
  }

  public String getDescription()
  {
	return description;
  }

  public String getId()
  {
	return id;
  }

  public DateTime getLastDateTimeModified()
  {
	return lastDateTimeModified;
  }

  public void setCompleted(Boolean completed)
  {
	this.completed = completed;
  }

  public void setDescription(String description)
  {
	this.description = description;
  }

  public void setId(String id)
  {
	this.id = id;
  }

  public void setLastDateTimeModified(DateTime lastDateTimeModified)
  {
	this.lastDateTimeModified = lastDateTimeModified;
  }

  @Override
  public String toString()
  {
	return "Todo [id=" + id + ", description=" + description + ", completed=" + completed + ", lastDateTimeModified="
	    + lastDateTimeModified + "]";
  }

}
