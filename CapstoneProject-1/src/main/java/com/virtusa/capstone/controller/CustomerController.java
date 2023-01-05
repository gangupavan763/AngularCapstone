package com.virtusa.capstone.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.capstone.model.Response;
import com.virtusa.capstone.model.UserModel;
import com.virtusa.capstone.service.AccountService;

@RestController
@RequestMapping("capstone/v1/")
@CrossOrigin("*")
public class CustomerController {
	@Autowired
	AccountService accountservice;
	
	@GetMapping("pavan")
	public String getString() {
		return 	"Welcome to the service Banking";
	}
	
	
	@PostMapping("/saveUser")
	public ResponseEntity<Response> saveCustomer(@RequestBody UserModel userModel) {
		String res =  accountservice.saveUser(userModel);
		Response r=new Response();
		r.setResponse(res);
		return ResponseEntity.ok().body(r);
	}
	

}
