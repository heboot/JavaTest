package com.heboot.javatest.thread;

public class ThreadT1ChildClass1 {
	// 方法签名 非静态修饰
	synchronized public void getValue() {
		System.out.println("getValue method thread name=" + Thread.currentThread().getName() + " username=" + "u"
				+ " password=" + "p");
	}

	// 方法签名 静态修饰
	synchronized static public void getValue2() {
		System.out.println("getValue method thread name=" + Thread.currentThread().getName() + " username=" + "u"
				+ " password=" + "p");
	}

	// 使用synchronized块对需要进行同步的代码段进行同步。
	public void serviceMethod() {
		try {
			synchronized (this) {
				System.out.println("begin time=" + System.currentTimeMillis());
				Thread.sleep(2000);
				System.out.println("end    end=" + System.currentTimeMillis());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
