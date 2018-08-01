/**
 * 
 */
package com.saurav.rules_poc.business.rule.result;

import com.saurav.rules_poc.business.Status;

import lombok.Data;

/**
 * @author Saurav
 *
 */
@Data
public class BusinessRuleResult {

	private Status staus;
	
	private String description;
	
	private Object data;
	
}
