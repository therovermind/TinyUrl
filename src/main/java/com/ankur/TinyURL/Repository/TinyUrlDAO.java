package com.ankur.TinyURL.Repository;

import com.ankur.TinyURL.Entity.TinyUrlEntity;

public interface TinyUrlDAO {
	//to save the url
	public long saveUrl(TinyUrlEntity t);
	
	//to get the url
	public String getUrl(long sequenceNo);

}
