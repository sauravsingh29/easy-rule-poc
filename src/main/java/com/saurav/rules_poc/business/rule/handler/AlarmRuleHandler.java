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
@Rule(name = "Alaram Rule", description = "Alaram rule will be triggered when fact value is greater than 10 and less than equal 20", priority = 2)
public class AlarmRuleHandler implements BusinessRule<BusinessDomain> {

	private boolean shouldBeEvent = false;

	@Override
	@Condition
	public boolean when(@Fact("input") BusinessDomain f) {
		return null != f && (f.getFact() > 10 && f.getFact() <= 20);
	}

	@Override
	@Action(order = 2)
	public void then() {
		shouldBeEvent = true;
		System.out.println("[x][x] Alarm Rule >> " + this.shouldBeEvent);
	}

	@Override
	public boolean shouldBeEvent() {
		return shouldBeEvent;
	}

}
