package com.ankur.TinyURL.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ankur.TinyURL.Model.UrlModel;

@RestController
@RequestMapping("/api")
public class TinyUrlController {
	
	@GetMapping
	public UrlModel getUrl(@RequestParam String url) {
		return 
	}
}
