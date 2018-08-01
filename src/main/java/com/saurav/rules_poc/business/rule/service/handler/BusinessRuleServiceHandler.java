/**
 * 
 */
package com.saurav.rules_poc.business.rule.service.handler;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saurav.rules_poc.business.domain.BusinessDomain;
import com.saurav.rules_poc.business.rule.service.BusinessRuleService;

/**
 * @author Saurav
 *
 */
@Service
public class BusinessRuleServiceHandler implements BusinessRuleService<BusinessDomain> {

	@Autowired
	RulesEngine rulesEngine;

	@Autowired
	Rules rules;

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
