package com.ankur.TinyURL.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ankur.TinyURL.Model.UrlModel;

@RestController
@RequestMapping("/api")
public class TinyUrlController {
	
	@GetMapping("/u")
	public UrlModel getUrl() {
		
	}
}
