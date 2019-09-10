package com.revature.calc;

import org.junit.Rule;
import org.junit.rules.ExpectedException; // saves us typing! dont need to use full qualifed class names.

public class CalculatorTest {
	
	
	
	/*
	 * Unit testing: testing most granular code possible- line and branch coverage of methods
	 * 
	 * TDD: style of development in which the tests are written before the code
	 * red green refactoring: start with requirment, write test, build code to match
	 * 
	 * 	1. calling add("") returns a double value of 0
	 *  2. calling add() with null returns 0
	 *  3. calling add with > 2 comma-seperated arguments throws calcualtor exceptio
	 *  4. calling add() with incorrect characters throws CalculatorException
	 *  5. calling add() with two comma-seperated numeric values returns their sum
	 */
	
	// if any excpetions is thrown, test will fail
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	
}
