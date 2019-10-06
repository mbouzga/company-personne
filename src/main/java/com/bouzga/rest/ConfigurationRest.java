package com.bouzga.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RefreshScope
@RestController
public class ConfigurationRest {

	private final static String URL = "http://localhost";
	@Value("${xParam}")
	private String xParam;
	@Value("${yParam}")
	private String yParam;
	@Value("${me}")
	private String me;
	@Value("${server.port}")
	private String applicationPort;
	
	@Autowired
    private RestTemplate restTemplate;
	
	@GetMapping("/getConfig")
	Map<String, Object> getConfig(){
		String uri = URL+":"+applicationPort+"/actuator/refresh";
		//TODO
		//restTemplate.postForEntity(uri, null, String.class);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("xParam", xParam);
		params.put("yParam", yParam);
		params.put("me", me);
		params.put("ThreadName", Thread.currentThread().getName());
		return params;
	}
}
