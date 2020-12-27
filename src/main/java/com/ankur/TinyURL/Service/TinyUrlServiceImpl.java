package com.ankur.TinyURL.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.ankur.TinyURL.Entity.TinyUrlEntity;
import com.ankur.TinyURL.Model.UrlModel;
import com.ankur.TinyURL.Repository.TinyUrlDAO;
import com.ankur.TinyURL.Util.TinyURLUtil;

@Service
public class TinyUrlServiceImpl implements TinyUrlService {
	
	@Autowired
	TinyUrlDAO tinyUrlDAO;
	
	@Autowired
	Environment env;
	
	public String getShortString(UrlModel urlModel) {
		
		String url = urlModel.getUrl();
		TinyUrlEntity entity = new TinyUrlEntity();
		entity.setOriginalUrl(url);
		int id = tinyUrlDAO.saveUrl(entity);
		String shortValue = TinyURLUtil.getShortString(id);
		String shortUrl = "localhost:"+ env.getProperty("server.port") +"/" + shortValue;
		return shortUrl;
	}
	
	public String getUrl(String url) {
		String[] s = url.split("/");
		String shortValue = s[s.length-1];
		int id = TinyURLUtil.getId(shortValue);
		String originalUrl = tinyUrlDAO.getUrl(id);
		return originalUrl;
	}

}
