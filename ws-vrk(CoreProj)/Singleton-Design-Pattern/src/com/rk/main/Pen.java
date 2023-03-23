package com.rk.main;

public class Pen extends Util {
	private static final long serialVersionUID=1L;
	private static Pen INSTANCE;
	private static boolean flag=false;
	
	private Pen() {
		if(flag==true)
			throw new IllegalArgumentException("Object already created..........");
		flag=true;
		System.out.println("Pen.Pen()");
	}
	public static Pen getPen() {
		if(INSTANCE==null) {
			synchronized (Pen.class) {
				if(INSTANCE==null)
					INSTANCE=new Pen();
								}
			}
			return INSTANCE;
		}
		public Object clone() {
			return INSTANCE;
		}
		public Object readResolve() {
			return INSTANCE;
		}
}
