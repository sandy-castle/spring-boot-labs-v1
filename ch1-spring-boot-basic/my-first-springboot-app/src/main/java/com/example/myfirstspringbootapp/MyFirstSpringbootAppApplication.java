package com.example.myfirstspringbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//어노테이션 위에있는게 있어야 스프링부트가 스프링 부트 답게 굴러감
public class MyFirstSpringbootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstSpringbootAppApplication.class, args);
	}

}
