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
	int id;
	@Column(name="ORIGIN_URL")
	String originalUrl;
	@Column(name="SHORT_URL")
	String smallUrl;
	
}
