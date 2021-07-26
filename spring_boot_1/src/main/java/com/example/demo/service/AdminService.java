package com.example.demo.service;

import java.sql.Date;
import java.sql.Time;

import org.springframework.stereotype.Service;

@Service
public class AdminService 
{
		public void Admission(String studentname, String class1, java.util.Date date) 
		{
			System.out.println("Studentname: "+ studentname + "\nClass: "+ class1  + "\nTime: "+ date);
		}

		public void Fee(Integer studentid, long feePaid, long feetobepaid) 
		{
			System.out.println("Studentid: "+ studentid + "\nFeetobepaid: "+ feetobepaid + "\nFeepaid: " + feePaid);
			if(feetobepaid==feePaid)
			{
				System.out.println("No due");
			}
			else if(feetobepaid>feePaid)
			{
				long c = feetobepaid-feePaid;
				System.out.println("The due amount is: "+ c);
			}
			else 
			{
				long c = feePaid-feetobepaid;
				System.out.println("Extra amount of " +c+ " is paid ");
			}
		}
}
