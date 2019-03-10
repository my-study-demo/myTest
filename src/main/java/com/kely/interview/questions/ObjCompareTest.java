package com.kely.interview.questions;

import org.junit.Test;

public class ObjCompareTest {
	
	public static void main(String[] args) {
		test1();
	}

	private static String getA(){return "a";}
	
	@Test
	private static void test1(){
		final String c = "a";
		String a = "a";
		
		String b = a + "b";//编译器优化成StringBuilder 
		String d = c + "b";
		String e = getA() + "b";//编译器优化成StringBuilder 
		
		String compare = "ab";
		System.out.println(b == compare);
		System.out.println(d == compare);
		System.out.println(e == compare);
	}
	
	@Test
	private static void test2(){
		String a = "a" + "b" + 1;
		String b = "ab1";
		System.out.println(a == b);
	}
	
	@Test
	private static void test3(){
		Integer a = new Integer("1");
		Integer b = new Integer("1");
		System.out.println(a.equals(b));
		System.out.println(a == b);
		
		Integer a1 = 2;
		Integer b1 = 2;
		System.out.println(a1.equals(b1));
		System.out.println(a1 == b1);
		
		Integer a2 = 200;
		Integer b2 = 200;
		System.out.println(a2.equals(b2));
		System.out.println(a2 == b2);
		System.out.println(a2.intValue() == b2.intValue());
		System.out.println(a2.intValue() == b2);
		System.out.println(a2 == b2.intValue());
	}
}
