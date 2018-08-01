/**
 * 
 */
package com.saurav.rules_poc.event.handler;

import org.springframework.stereotype.Component;

import com.saurav.rules_poc.business.rule.result.BusinessRuleResult;
import com.saurav.rules_poc.event.Router;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Saurav
 *
 */
@Slf4j
@Component
public class RouterHandler implements Router<BusinessRuleResult> {

	@Override
	public void route(BusinessRuleResult result) {
		log.info("Publishing generated event data {}", result.toString());
	}

}
