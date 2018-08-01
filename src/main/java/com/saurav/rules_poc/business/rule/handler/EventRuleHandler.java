/**
 * 
 */
package com.saurav.rules_poc.business.rule.handler;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import com.saurav.rules_poc.business.domain.BusinessDomain;
import com.saurav.rules_poc.business.rule.BusinessRule;

/**
 * @author Saurav
 *
 */
@Rule(name = "Event Rule", description = "Event rule will be triggered when fact value is greater than 20 and less than equal 80", priority = 1)
public class EventRuleHandler implements BusinessRule<BusinessDomain> {

	private boolean shouldBeEvent = false;

	@Override
	@Condition
	public boolean when(@Fact("input") BusinessDomain f) {
		return null != f && (f.getFact() > 20 && f.getFact() <= 80);
	}

	@Override
	@Action(order = 1)
	public void then() {
		shouldBeEvent = true;
		System.out.println("[x][x] Event Rule >> " + this.shouldBeEvent);
	}

	@Override
	public boolean shouldBeEvent() {
		return shouldBeEvent;
	}

}
