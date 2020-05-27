package com.prasidyo.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.prasidyo.api.ModelUser;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ApiController {

	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseBody
	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> auth(@RequestBody ModelUser input) {
		Map<String, Object> map = new HashMap<String, Object>();

		if (input.getPassword().equals("rahasia")) {
			map.put("username", input.getUsername());
		} else {

		}

		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<String> index() {
		String isi = "Saya adalah makelar kopi, tinggal di Laurier No. 37.";
		System.out.print(isi);

		return new ResponseEntity<String>(isi, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/query/cb/date", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<Map<String, Object>>> getDocument(@RequestBody String input) {
		Map<String, Object> map = new HashMap<String, Object>();
		ArrayList<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();

		map.put("doc", "1 document document documentdocument document document documentdocument document document");
		map.put("error", "Error");
		map.put("error_message",
				"Pesan error Pesan error Pesan error Pesan error asdasdasdaPesan error Pesan error asdasdasda");
		map.put("id", "01::158555888");
		map.put("src_table_name", "01");
		map.put("state", "StreamTransformation");
		map.put("status", "Submitted");
		map.put("timestamps", "2020-05-06 13:00:01");
		map.put("type", "PruCare");

		maps.add(map);

		map = new HashMap<String, Object>();
		map.put("doc", "2 document document documentdocument document document");
		map.put("error", "Connection exception");
		map.put("error_message", "Pesan error Pesan error Pesan error Pesan error asdasdasda");
		map.put("id", "02::228555888");
		map.put("src_table_name", "02");
		map.put("state", "StreamTransformation");
		map.put("status", "Error");
		map.put("timestamps", "2020-05-06 13:00:01");
		map.put("type", "PruCare");

		maps.add(map);
		map = new HashMap<String, Object>();
		map.put("doc", "3 document document documentdocument document document");
		map.put("error", "Connection exception");
		map.put("error_message", "Pesan error Pesan error Pesan error Pesan error asdasdasda");
		map.put("id", "03::228555888");
		map.put("src_table_name", "02");
		map.put("state", "StreamTransformation");
		map.put("status", "Error");
		map.put("timestamps", "2020-05-06 13:00:01");
		map.put("type", "Eventing");

		maps.add(map);
		
		map = new HashMap<String, Object>();
		map.put("doc", "4 document document documentdocument document document");
		map.put("error", "Connection exception");
		map.put("error_message", "Pesan error Pesan error Pesan error Pesan error asdasdasda");
		map.put("id", "04::228555888");
		map.put("src_table_name", "02");
		map.put("state", "StreamTransformation");
		map.put("status", "Submitted");
		map.put("timestamps", "2020-05-06 13:00:01");
		map.put("type", "Eventing");

		maps.add(map);

		return new ResponseEntity<ArrayList<Map<String, Object>>>(maps, HttpStatus.OK);

	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseBody
	@RequestMapping(value = "/query/cb/id/{id}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getDocumentById(@PathVariable String id) {
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			
			System.out.println("id:" + id);
			map = new HashMap<String, Object>();
			map.put("doc", "4 document document documentdocument document document");
			map.put("error", "Connection exception");
			map.put("error_message", "Pesan error Pesan error Pesan error Pesan error asdasdasda");
			map.put("id", "04::228555888");
			map.put("src_table_name", "02");
			map.put("state", "StreamTransformation");
			map.put("status", "Submitted");
			map.put("timestamps", "2020-05-06 13:00:01");
			map.put("type", "Eventing");

			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (Exception e) {
			map.put("data", e.getMessage());
			map.put("status", false);
			e.printStackTrace();
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseBody
	@RequestMapping(value = "/getData", method = RequestMethod.GET)
	public Map<String, Object> getData() {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, String> detail = new HashMap<String, String>();

		detail.put("1", "satu");
		detail.put("2", "dua");
		detail.put("3", "tiga");
		detail.put("4", "empat");
		map.put("A", detail);

		map.put("B", new ArrayList<String>() {
			{
				add("lima");
				add("enam");
				add("tujuh");
			}
		});

		map.put("C", "delapan");
		map.put("D", 9);
		map.put("E", 10.000);
		map.put("F", "");
		map.put("G", null);

		return map;
	}

	@CrossOrigin(origins = "http://localhost:4200")
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

	// @CrossOrigin(origins = "http://localhost:4200")
	@ResponseBody
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getUser() {
		Map<String, Object> map = new HashMap<String, Object>();
		ArrayList<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
		Map<String, Object> output = new HashMap<String, Object>();

		map.put("id", 1);
		map.put("username", "prasidyo");
		map.put("password", "pass");
		maps.add(map);

		map = new HashMap<String, Object>();
		map.put("id", 2);
		map.put("username", "adi");
		map.put("password", "passadi");

		maps.add(map);

		output.put("data", maps);

		return new ResponseEntity<Map<String, Object>>(output, HttpStatus.OK);

	}

	// @CrossOrigin(origins = "http://localhost:4200")
	@ResponseBody
	@RequestMapping(value = "/postUser", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> postUser(@RequestBody ModelUser input) {
		Map<String, Object> map = new HashMap<String, Object>();

		if (input.getPassword().equals("rahasia")) {
			map.put("id", input.getId());
			map.put("username", input.getUsername());
			map.put("status", "success");
		} else {
			// map.put("id", input.getId());
			// map.put("username", input.getUsername());
			// map.put("password", input.getPassword());
			// map.put("status", "error");
			// map.put("reason", "Password tidak sesuai!");

		}

		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

	}
}
