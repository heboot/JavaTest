package com.heboot.javatest.rx;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.schedulers.Schedulers;

public class ZipTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable<String> O1 = Observable.create(new ObservableOnSubscribe<String>() {
			@Override
			public void subscribe(ObservableEmitter<String> emitter) throws Exception {
				System.out.println("发射器1");
				emitter.onNext("发射器1 next");
				 Thread.sleep(1000);  
				System.out.println("发射器1.1");
				emitter.onNext("发射器1 next");
				 Thread.sleep(1000);  
				System.out.println("发射器1.2");
				emitter.onNext("发射器1 next");
				 Thread.sleep(1000);  
				System.out.println("发射器1.3");
				emitter.onNext("发射器1 next");
				 Thread.sleep(1000);  
				System.out.println("发射器1.4");
				emitter.onNext("发射器1 next");
				 Thread.sleep(1000);  
				System.out.println("发射器1.5");
				emitter.onComplete();
			}
		}).subscribeOn(Schedulers.io());

		Observable<String> O2 = Observable.create(new ObservableOnSubscribe<String>() {
			@Override
			public void subscribe(ObservableEmitter<String> emitter) throws Exception {
				System.out.println("发射器2");
				emitter.onNext("发射器2 next");
				 Thread.sleep(1000);  
				System.out.println("发射器2.1");
				emitter.onNext("发射器2 next");
				 Thread.sleep(1000);  
				System.out.println("发射器2.2");
				emitter.onNext("发射器2 next");
				 Thread.sleep(1000);  
				System.out.println("发射器2.3");
				emitter.onNext("发射器2 next");
				 Thread.sleep(1000);  

				emitter.onComplete();
			}
		}).subscribeOn(Schedulers.io());

		Observable<String> O3 = Observable.create(new ObservableOnSubscribe<String>() {
			@Override
			public void subscribe(ObservableEmitter<String> emitter) throws Exception {
				System.out.println("发射器3");
				emitter.onNext("发射器3 next");
			}
		});

		Observable<String> O4 = Observable.create(new ObservableOnSubscribe<String>() {
			@Override
			public void subscribe(ObservableEmitter<String> emitter) throws Exception {
				System.out.println("发射器4");
				emitter.onNext("发射器4 next");
			}
		});

		Observable.zip(O1, O2, new BiFunction<String, String, String>() {

			@Override
			public String apply(String t1, String t2) throws Exception {
				// TODO Auto-generated method stub
				return t1 + t2;
			}

		}).subscribe(new Observer<String>() {

			@Override
			public void onSubscribe(Disposable d) {
				// TODO Auto-generated method stub
				System.out.println("last onSubscribe   ");
			}

			@Override
			public void onNext(String t) {
				// TODO Auto-generated method stub
				System.out.println("last onnext = " + t);
			}

			@Override
			public void onError(Throwable e) {
				// TODO Auto-generated method stub
				System.out.println("last onError   " + e.getMessage());
			}

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				System.out.println("last onComplete  ");
			}
		});

	}

}
