package com.ankur.TinyURL.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="URLS")
public class TinyUrlEntity {
	
	@Id
	@GeneratedValue
	private int id;
	@Column(name="ORIGIN_URL")
	private String originalUrl;
	public String getOriginalUrl() {
		return originalUrl;
	}
	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}
	
	
}
