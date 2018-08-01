package com.saurav.rules_poc;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.saurav.rules_poc.business.domain.BusinessDomain;
import com.saurav.rules_poc.business.rule.service.handler.BusinessRuleServiceHandler;

@SpringBootApplication
public class EasyRulePocApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyRulePocApplication.class, args);
	}

	@Autowired
	private BusinessRuleServiceHandler businessRuleServiceHandler;

	@Bean
	CommandLineRunner runner() {
		return (r) -> {
			List<BusinessDomain> bds = Arrays.asList(new BusinessDomain(UUID.randomUUID(), 92),
					new BusinessDomain(UUID.randomUUID(), 60), new BusinessDomain(UUID.randomUUID(), 15),
					new BusinessDomain(UUID.randomUUID(), 80));
			bds.stream().forEach(bd -> {
				businessRuleServiceHandler.execute(bd);
			});
		};
	}
}
