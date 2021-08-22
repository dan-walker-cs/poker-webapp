package com.dan_walker_cs.have_them_webapp;

import com.dan_walker_cs.have_them_webapp.accounts.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// Implicitly defines a base search package for the classpath scan
// Best practice to keep with main class/method
@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class SpringFullstackApplication {

	public static void main(String[] args) {
		// Starts application, creates servlet container, hosts application within that container
		// More specifically, sets up the default configuration, starts the Spring Application Context,
		//		performs class path scan (annotations), and starts Tomcat server.
		// arg1 = class where main method lives, arg2 = args variable from main method
		SpringApplication.run(SpringFullstackApplication.class, args);
	}

}
