package com.rk.main;

public enum MySingleton {
	INSTANCE;
		private int count=0;
		private MySingleton() {
			System.out.println("here"+count+1);
		}
}
