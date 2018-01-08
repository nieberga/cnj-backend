package edu.hm.cs.cnj.cnjbackend.ads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.Api;



@RestController
@RequestMapping("/v1/adproxy")
@Api
public class AdController {

	@Autowired
	AdClient adClient;
	
	@GetMapping
	public String getAd() {
		return adClient.getAd();
	}
	
}
