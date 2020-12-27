package com.ankur.TinyURL.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ankur.TinyURL.Model.UrlModel;
import com.ankur.TinyURL.Service.TinyUrlService;

@RestController
@RequestMapping
public class TinyUrlController {
	
	@Autowired
	TinyUrlService urlService;
	
	@GetMapping("/api")
	public UrlModel getUrl(@RequestBody UrlModel urlModel) {
		String url = urlModel.getUrl();
		String s = urlService.getUrl(url);
		UrlModel newUrlModel = new UrlModel();
		newUrlModel.setUrl(s);
		return newUrlModel;
	}
	
	@PostMapping("/api")
	public UrlModel getShortUrl(@RequestBody UrlModel urlModel) {
		
		String s = urlService.getShortString(urlModel);
		UrlModel newUrlModel = new UrlModel();
		newUrlModel.setUrl(s);
		return newUrlModel;
	}
	
}
