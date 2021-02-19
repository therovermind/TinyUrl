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
	
	private volatile int id = 100000;
	
	public String getShortString(UrlModel urlModel) throws Exception {
		String regex = "(http|Http|Https|https|ftp)?:?(\\/\\/www)?\\..*\\..*";
		String url = urlModel.getUrl();
		if(!url.matches(regex)) {
			throw new Exception("UNCORRECT_URL");
		}
		TinyUrlEntity entity = new TinyUrlEntity();
		entity.setOriginalUrl(url);
		id = id +1;
		entity.setId(id);
	    tinyUrlDAO.saveUrl(entity);
		String shortValue = TinyURLUtil.getShortString(id);
		String shortUrl = "localhost:"+ env.getProperty("server.port") +"/" + shortValue;
		return shortUrl;
	}
	
	public String getUrl(String url) throws Exception {
		String[] s = url.split("/");
		String shortValue = s[s.length-1];
		int id = TinyURLUtil.getId(shortValue);
		String originalUrl = tinyUrlDAO.getUrl(id);
		return originalUrl;
	}

}
