/**
 * 
 */
package com.saurav.rules_poc.business.rule;

/**
 * @author Saurav
 *
 */
public interface BusinessRule<F> {
	
	boolean when(F f);

	void then();

}
