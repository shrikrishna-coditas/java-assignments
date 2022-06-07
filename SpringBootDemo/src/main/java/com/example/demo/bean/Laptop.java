package com.example.demo.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Laptop {
	@Autowired
	HardDisk hd;
	
	public void show() {
		System.out.println("This is laptop show method");
		System.out.println("Hitachi hard-disk==>"+hd.details());
	}
}
