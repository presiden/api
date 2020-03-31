package com.prasidyo.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
	
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public static String home() {
		System.out.print("home console");
		return "home api sukses";
	}

	@CrossOrigin(origins = "http://localhost")
	@ResponseBody
	@RequestMapping(value = "/getData", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getData() {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, String> detail = new HashMap<String, String>();
		
		detail.put("1", "satu");
		detail.put("2", "dua");
		detail.put("3", "tiga");
		map.put("A", detail);
		
		detail = new HashMap<String, String>();
		detail.put("4", "empat");
		detail.put("5", "lima");
		detail.put("6", "enam");
		map.put("B", detail);
		
		
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
}
