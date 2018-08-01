/**
 * 
 */
package com.saurav.rules_poc.business.domain;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Saurav
 *
 */
@Data
@AllArgsConstructor
public class BusinessDomain {
	
	private UUID assetId;
	
	private Integer fact;

}
