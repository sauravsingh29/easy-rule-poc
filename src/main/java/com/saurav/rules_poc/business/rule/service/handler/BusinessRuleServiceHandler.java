/**
 * 
 */
package com.saurav.rules_poc.business.rule.service.handler;

import javax.annotation.PostConstruct;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saurav.rules_poc.business.domain.BusinessDomain;
import com.saurav.rules_poc.business.rule.handler.AlarmRuleHandler;
import com.saurav.rules_poc.business.rule.handler.EventRuleHandler;
import com.saurav.rules_poc.business.rule.service.BusinessRuleService;
import com.saurav.rules_poc.business.rule.util.RuleBuilder;

/**
 * @author Saurav
 *
 */
@Service
public class BusinessRuleServiceHandler implements BusinessRuleService<BusinessDomain> {

	@Autowired
	private RulesEngine rulesEngine;

	private Rules rules;

	@Autowired
	private EventRuleHandler eventRuleHandler;

	@Autowired
	private AlarmRuleHandler alarmRuleHandler;

	@PostConstruct
	public void buildRules() {
		this.rules = RuleBuilder.build(eventRuleHandler, alarmRuleHandler);
	}

	private Facts facts = new Facts();

	@Override
	public void execute(BusinessDomain domain) {
		facts.put("input", domain);
		rulesEngine.check(rules, facts).entrySet().stream().forEach(rf -> {
			if (rf.getValue() == Boolean.TRUE) {
				try {
					rf.getKey().execute(facts);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
