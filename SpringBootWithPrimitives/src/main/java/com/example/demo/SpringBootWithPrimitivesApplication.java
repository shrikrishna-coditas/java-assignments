package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.bean.Student;

@SpringBootApplication
public class SpringBootWithPrimitivesApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext c=SpringApplication.run(SpringBootWithPrimitivesApplication.class, args);
		Student s=c.getBean(Student.class);
		System.out.println(s);
	}

}
