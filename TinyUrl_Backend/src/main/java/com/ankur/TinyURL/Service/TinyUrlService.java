package com.ankur.TinyURL.Service;

import com.ankur.TinyURL.Model.UrlModel;

public interface TinyUrlService {
	//this method will unique base converted value.
	public String getShortString(UrlModel urlModel) throws Exception;
	
	//this will give full url.
	public String getUrl( String s) throws Exception;

}
