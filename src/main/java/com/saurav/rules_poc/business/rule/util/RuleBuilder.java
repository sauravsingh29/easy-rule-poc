/**
 * 
 */
package com.saurav.rules_poc.business.rule.util;

import org.jeasy.rules.api.Rules;

/**
 * @author Saurav
 *
 */
public final class RuleBuilder {

	private RuleBuilder() {
	}

	public static Rules build(Object... rules) {
		return new Rules(rules);
	}

}
