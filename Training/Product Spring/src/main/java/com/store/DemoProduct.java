package com.store;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoProduct {
	
	@GetMapping("/getMessage")
	public String getMessage()
	{
		return "This is a Product table";
	}

}
