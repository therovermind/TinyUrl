package com.ankur.TinyURL.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="STORE")
public class TinyUrlEntity {
	
	@Id
	@GeneratedValue
	int id;
	String originalUrl;
	String smallUrl;
	
}
