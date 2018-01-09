package com.heboot.javatest.rx;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import io.reactivex.Observable;

public class T2 {
	public static void main(String[] args) throws Exception {
		// Observable.create(e -> {
		// e.onNext("Love");
		// e.onNext("For");
		// e.onNext("You!");
		// e.onComplete();
		// }).subscribe(s -> System.out.println(s));

		Observable.create(e -> {
			e.onNext("Love");
			e.onNext("For");
			e.onNext("You!");
			e.onComplete();
		}).subscribe(s -> System.out.println(s));

		Map<String,String> testMap = new HashMap();
		String s= testMap.put("1", "1");
		String s2= testMap.put("1", "1");
		System.out.println(s2);

	}
}
