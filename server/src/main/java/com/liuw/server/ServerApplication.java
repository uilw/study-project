package com.liuw.server;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Liuw
 * @date 2020-05-14
 */
@Slf4j
@SpringBootApplication
@MapperScan("com.liuw.server.db.mapper")
public class ServerApplication {

	public static void main(String[] args) throws UnknownHostException {

		SpringApplication app = new SpringApplication(ServerApplication.class);

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
