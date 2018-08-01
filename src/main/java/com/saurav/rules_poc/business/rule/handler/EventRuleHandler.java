/**
 * 
 */
package com.saurav.rules_poc.business.rule.handler;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import org.springframework.stereotype.Component;

import com.saurav.rules_poc.business.Status;
import com.saurav.rules_poc.business.domain.BusinessDomain;
import com.saurav.rules_poc.business.rule.BusinessRule;
import com.saurav.rules_poc.business.rule.result.BusinessRuleResult;
import com.saurav.rules_poc.event.Router;

/**
 * @author Saurav
 *
 */
@Component
@Rule(name = "Event Rule", description = "Event rule will be triggered when fact value is greater than 20 and less than equal 80", priority = 1)
public class EventRuleHandler implements BusinessRule<BusinessDomain> {

	private Router<BusinessRuleResult> router;

	private BusinessDomain data;

	public EventRuleHandler(Router<BusinessRuleResult> router) {
		this.router = router;
	}

	@Override
	@Condition
	public boolean when(@Fact("input") BusinessDomain f) {
		this.data = f;
		return null != this.data && (this.data.getFact() > 20 && this.data.getFact() <= 80);
	}

	@Override
	@Action(order = 1)
	public void then() {
		final BusinessRuleResult result = new BusinessRuleResult();
		result.setStaus(Status.EVENT);
		result.setDescription("Event has been generate!");
		result.setData(data);
		this.router.route(result);
	}

}
