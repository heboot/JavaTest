package com.heboot.javatest.thread;

public class ThreadT1 {

	public static void main(String[] args) throws Exception {

		ThreadT1ChildClass1 threadT1ChildClass1 = new ThreadT1ChildClass1();
		
		threadT1ChildClass1.getValue();
		
		threadT1ChildClass1.serviceMethod();
		
		threadT1ChildClass1.getValue2();
		
		
	}

}
