package com.heboot.javatest.rx;

import java.nio.charset.MalformedInputException;
import java.security.Policy.Parameters;
import java.util.HashMap;
import java.util.Map;

import org.reactivestreams.Subscriber;

import com.alibaba.fastjson.JSON;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class T1 {

	public static void main(String[] args) throws Exception {

		Observable observable = Observable.create(new ObservableOnSubscribe<Object>() {

			@Override
			public void subscribe(ObservableEmitter<Object> e) throws Exception {
				System.out.println("test");
				e.onNext("wocao");
//				e.onError(new Throwable());
				// e.onComplete();

			}
		});
		
		observable.subscribe();

		ProgressSub progressSub = new ProgressSub();
//		observable.subscribe(progressSub);
//		observable.subscribe(progressSub);

		Observable.create(e -> {

		});

		//
		// Map<String, String> params = new HashMap<>();
		//
		// params.put("key1", "value1");
		// params.put("key2", "value2");
		// params.put("key3", "value3");
		// params.put("key4", "value4");
		//
		// System.out.println(JSON.toJSONString(params));
		//
		// params.clear();
		//
		// System.out.println(JSON.toJSONString(params));
		//
		//
		// params.put("key1", "value1");
		// params.put("key2", "value2");
		// params.put("key3", "value3");
		// params.put("key4", "value4");
		//
		// System.out.println(JSON.toJSONString(params));

		// name("1", "2", "3", "4"); // 可变参数测试
	}

	public static void name(String arg1, String... args2) {
		for (String string : args2) {
			System.out.println(string);
		}

	}

	static class ProgressSub implements Observer {

		private Disposable md;

		@Override
		public void onSubscribe(Disposable d) {
			md = d;
			// d.dispose();
			// TODO Auto-generated method stub
			System.out.println("onSubscribe" + d);

		}

		@Override
		public void onNext(Object t) {
			// TODO Auto-generated method stub
			System.out.println("onNext");
		}

		@Override
		public void onError(Throwable e) {
			// TODO Auto-generated method stub
			System.out.println("onError" + md + "<>>>>" + this);
			md.dispose();
		}

		@Override
		public void onComplete() {
			// TODO Auto-generated method stub
			System.out.println("onComplete");
		}

	}
}
