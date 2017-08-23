package br.com.toyoda.elo7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SondaSolrApplication {
	
	private final static Logger log = LoggerFactory.getLogger(SondaSolrApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SondaSolrApplication.class, args);
	}
}
