/**
 * 
 */
package com.saurav.rules_poc.event;

/**
 * @author Saurav
 *
 */
public interface Router<T> {

	void route(T result);
}
