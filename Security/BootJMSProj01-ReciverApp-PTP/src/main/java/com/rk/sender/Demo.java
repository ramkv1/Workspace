package com.rk.sender;

import java.util.StringTokenizer;

class Demo {
	public static void main(String args[]) {
		String s = "Welcome to Java";
		StringTokenizer st = new StringTokenizer(s);
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
			System.out.println("------------------");
		}
	}
}