package org.effectivejava.examples.chapter02.item05;

public class Sum {
	// Hideously slow program! Can you spot the object creation?
	public static void sum_1() {
		Long sum = 0L;
		for (long i = 0; i < Integer.MAX_VALUE; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
	
	public static void sum_2() {
		long sum = 0L;
		for (long i = 0; i < Integer.MAX_VALUE; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
	
	public static void main(String[] args) {
		long startTime1 = System.currentTimeMillis();
		sum_1();
		long endTime1 = System.currentTimeMillis();
		System.out.println("sum_1程序运行时间： "+(endTime1-startTime1)+"ms");
		
		long startTime2 = System.currentTimeMillis();
		sum_2();
		long endTime2 = System.currentTimeMillis();
		System.out.println("sum_2程序运行时间： "+(endTime2-startTime2)+"ms");
		
	}
	
	
}
