package org.effectivejava.examples.chapter03.item09;

// Shows the need for overriding hashcode when you override equals - Pages 45-46

import java.util.HashMap;
import java.util.Map;

public final class PhoneNumber {
	private final short areaCode;
	private final short prefix;
	private final short lineNumber;

	public PhoneNumber(int areaCode, int prefix, int lineNumber) {
		rangeCheck(areaCode, 999, "area code");
		rangeCheck(prefix, 999, "prefix");
		rangeCheck(lineNumber, 9999, "line number");
		this.areaCode = (short) areaCode;
		this.prefix = (short) prefix;
		this.lineNumber = (short) lineNumber;
	}

	private static void rangeCheck(int arg, int max, String name) {
		if (arg < 0 || arg > max)
			throw new IllegalArgumentException(name + ": " + arg);
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof PhoneNumber))
			return false;
		PhoneNumber pn = (PhoneNumber) o;
		return pn.lineNumber == lineNumber && pn.prefix == prefix
				&& pn.areaCode == areaCode;
	}

	// Broken - no hashCode method!

	// A decent hashCode method - Page 48
	// @Override public int hashCode() {
	// int result = 17;
	// result = 31 * result + areaCode;
	// result = 31 * result + prefix;
	// result = 31 * result + lineNumber;
	// return result;
	// }

	// Lazily initialized, cached hashCode - Page 49
	// private volatile int hashCode; // (See Item 71)
	//
	// @Override public int hashCode() {
	// int result = hashCode;
	// if (result == 0) {
	// result = 17;
	// result = 31 * result + areaCode;
	// result = 31 * result + prefix;
	// result = 31 * result + lineNumber;
	// hashCode = result;
	// }
	// return result;
	// }

//	31是个奇素数，习惯上使用数数来计算散列结果。
//	31有个很好的特性，即用位移和减法来代替乘法，可以得到更好的性能：31 * i == (i << 5) - i;且VM可以自动完成这种优化。
	
	public static void main(String[] args) {
		Map<PhoneNumber, String> m = new HashMap<PhoneNumber, String>();
		m.put(new PhoneNumber(707, 867, 5309), "Jenny");
		System.out.println(m.get(new PhoneNumber(707, 867, 5309)));
//		Test
//		PhoneNumber pn = new PhoneNumber(707, 867, 5309);
//		m.put(pn, "Jenny");
//		System.out.println(m.get(pn));
	}
}
