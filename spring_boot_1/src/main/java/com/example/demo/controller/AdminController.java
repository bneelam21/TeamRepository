package com.example.demo.controller;


import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.AdminService;



@RestController
@RequestMapping("school/Admin")
public class AdminController 
{
	@Autowired
	private AdminService adminservice;
	
	@PostMapping(path = "AdminService", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String Admission(@RequestBody Map<String, String> map) 
	{
        Date date = new Date();
        adminservice.Admission(map.get("studentname"),map.get("Class"), date);
        return "Admission Successful";
    }
	
	
	@PostMapping(path = "Fee", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String Fee(@RequestBody Map<String, Integer> map) 
	{ 
		long FeeToBePaid = 30000;
		long FeePaid = map.get("amountpaid");
		adminservice.Fee(map.get("studentid"),map.get("amountpaid"),FeeToBePaid);
		if(FeeToBePaid==FeePaid)
		{
			return "No due";
		}
		else if(FeeToBePaid>FeePaid)
		{
			long c = FeeToBePaid-FeePaid;
			String due=String.valueOf(c); 
			return due;
		}
		else 
		{
			return "Extra amount paid";
		}
    }
}
