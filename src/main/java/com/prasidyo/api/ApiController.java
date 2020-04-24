package com.prasidyo.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

	//@CrossOrigin(origins = "http://localhost")
	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<String> index() {
		String isi = "Saya adalah makelar kopi, tinggal di Laurier No. 37.";
		System.out.print(isi);

		return new ResponseEntity<String>(isi, HttpStatus.OK);
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
		detail.put("4", "empat");
		map.put("A", detail);

		map.put("B", new ArrayList<String>(){{add("lima"); add("enam"); add("tujuh");}});
		
		map.put("C", "delapan");
		map.put("D", 9);
		map.put("E", 10.000);
		map.put("F", "");
		map.put("G", null);

		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost")
	@ResponseBody
	@RequestMapping(value = "/postData", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getPaymentVoucherDtl(@RequestBody Map<String, Object> input) {
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			input.put("message", "sukses");
			map.put("status", true);
			map.put("data", input);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (Exception e) {
			map.put("data", e.getMessage());
			map.put("status", false);
			e.printStackTrace();
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
		}
	}
}
