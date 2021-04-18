package com.ankur.TinyURL.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity 
@Table(name="URLS")
public class TinyUrlEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sId")
	private int sId;
	@Column(name="id")
	private int id;
	public String getId() {
		return originalUrl;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="ORIGIN_URL")
	private String originalUrl;
	public String getOriginalUrl() {
		return originalUrl;
	}
	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}
	
	
}
