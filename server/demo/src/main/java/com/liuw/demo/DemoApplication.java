package com.liuw.demo;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication
@MapperScan("com.liuw.demo.db.mapper")
public class DemoApplication {

	public static void main(String[] args) throws UnknownHostException {

		SpringApplication app = new SpringApplication(DemoApplication.class);

		Environment env = app.run(args).getEnvironment();
		String protocol = "http";
		String  keyStore = "server.ssl.key-store";
		if (env.getProperty(keyStore) != null) {
			protocol = "https";
		}
		log.info(		"\n----------------------------------------------------------\n\t"
						+ "Application '{}' is running! Access URLs:\n\t"
						+ "Local: \t\t{}://localhost:{}{}/swagger-ui.html\n\t"
						+ "External: \t{}://{}:{}{}/swagger-ui.html\n\t"
						+ "Profile(s): \t{}\n----------------------------------------------------------",
				env.getProperty("spring.application.name"),
				protocol,
				env.getProperty("server.port"),
				env.getProperty("server.servlet.context-path"),
				protocol,
				InetAddress.getLocalHost().getHostAddress(),
				env.getProperty("server.port"),
				env.getProperty("server.servlet.context-path"),
				env.getActiveProfiles());
	}

}
