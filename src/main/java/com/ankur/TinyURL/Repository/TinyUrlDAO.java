package com.ankur.TinyURL.Repository;

import com.ankur.TinyURL.Entity.TinyUrlEntity;

public interface TinyUrlDAO {
	//to save the url
	public int saveUrl(TinyUrlEntity t);
	
	//to get the url
	public String getUrl(int sequenceNo) throws Exception;

}
