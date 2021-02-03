package com.ankur.TinyURL.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ankur.TinyURL.Model.UrlModel;
import com.ankur.TinyURL.Service.TinyUrlService;

@CrossOrigin
@RestController
@RequestMapping
public class TinyUrlController {
	
	@Autowired
	TinyUrlService urlService;
	
	@Autowired
	Environment env;
	
	@GetMapping("/api/{url}")
	public ResponseEntity<UrlModel> getUrl(@PathVariable String url) {
		try {
		String s = urlService.getUrl(url);
		UrlModel newUrlModel = new UrlModel();
		newUrlModel.setUrl(s);
		return new ResponseEntity<UrlModel>(newUrlModel, HttpStatus.OK);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,env.getProperty(e.getMessage()));
		}
	}
	
	@PostMapping("/api")
	public ResponseEntity<UrlModel> getShortUrl(@RequestBody UrlModel urlModel) {
		try {
		String s = urlService.getShortString(urlModel);
		UrlModel newUrlModel = new UrlModel();
		newUrlModel.setUrl(s);
		return new ResponseEntity<UrlModel>(newUrlModel, HttpStatus.OK);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,env.getProperty(e.getMessage()));
		}
	}
	
}
