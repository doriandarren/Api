package com.project.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

@Entity
public class Ping{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key key;
	private String codeId; 
	private String data;
	private Long  timestamp; 
	
	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public String getCodeId() {
		return codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data= data;
	}


	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	} 

}
