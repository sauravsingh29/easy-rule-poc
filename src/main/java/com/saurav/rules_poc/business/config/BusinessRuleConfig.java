/**
 * 
 */
package com.saurav.rules_poc.business.config;

import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.saurav.rules_poc.business.rule.handler.AlarmRuleHandler;
import com.saurav.rules_poc.business.rule.handler.EventRuleHandler;

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

	@Bean
	Rules rules() {
		final Rules rules = new Rules();
		rules.register(new EventRuleHandler());
		rules.register(new AlarmRuleHandler());
		return rules;
	}
}
