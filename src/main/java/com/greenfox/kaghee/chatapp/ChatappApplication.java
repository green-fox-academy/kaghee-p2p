package com.greenfox.kaghee.chatapp;

import com.greenfox.kaghee.chatapp.models.Status;
import com.greenfox.kaghee.chatapp.service.MessageHandler;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
public class ChatappApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ChatappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
