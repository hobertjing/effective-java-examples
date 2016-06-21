// Noninstantiable utility class
package org.effectivejava.examples.chapter02.item04;

public class UtilityClass {
	// Suppress default constructor for noninstantiability
	private UtilityClass() {
		throw new AssertionError();//不是必须的，但是可以避免不小心在类的内部调用构造器
	}
}
