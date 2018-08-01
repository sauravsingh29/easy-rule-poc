/**
 * 
 */
package com.saurav.rules_poc.business.config;

import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Saurav
 *
 */
@Configuration
public class BusinessRuleConfig {

	@Bean
	RulesEngine rulesEngine() {
		return new DefaultRulesEngine();
	}

}
