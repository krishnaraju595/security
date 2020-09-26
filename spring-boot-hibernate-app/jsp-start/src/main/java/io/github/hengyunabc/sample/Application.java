package io.github.hengyunabc.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * http://localhost:8080
 * http://localhost:8080/hello
 * http://localhost:8080/hello-from-common
 *
 * </pre>
 *
 *
 */
@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
