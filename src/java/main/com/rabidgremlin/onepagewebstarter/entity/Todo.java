package com.rabidgremlin.onepagewebstarter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.joda.time.DateTime;

// TODO lok at using NamedQueries http://stackoverflow.com/questions/9793252/selecting-all-rows-from-a-database-using-jpa-in-websphere

@Entity
@Table(name = "todo")
public class Todo {
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	public DateTime getLastDateTimeModified() {
		return lastDateTimeModified;
	}

	public void setLastDateTimeModified(DateTime lastDateTimeModified) {
		this.lastDateTimeModified = lastDateTimeModified;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", description=" + description
				+ ", completed=" + completed + ", lastDateTimeModified="
				+ lastDateTimeModified + "]";
	}

}
