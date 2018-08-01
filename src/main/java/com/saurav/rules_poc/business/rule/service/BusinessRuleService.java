/**
 * 
 */
package com.saurav.rules_poc.business.rule.service;

/**
 * @author Saurav
 *
 */
public interface BusinessRuleService<T> {

	void execute(T domain);

}
