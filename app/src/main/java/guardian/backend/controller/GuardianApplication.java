package guardian.backend.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GuardianApplication {
	public static void main(String[] args) {
		SpringApplication.run(GuardianApplication.class, args);
		System.out.println("Server started...");
	}
}