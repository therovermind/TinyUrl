package com.ankur.TinyURL.Service;

public interface TinyUrlService {
	//this method will unique base converted value.
	public String getShortString(long l);
	
	//this will give full url.
	public String getUrl( String s);

}
