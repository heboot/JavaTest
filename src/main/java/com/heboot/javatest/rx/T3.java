package com.heboot.javatest.rx;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public class T3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable<Integer> o1 = Observable.create(new ObservableOnSubscribe<Integer>() {

			@Override
			public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
				// emitter 发射器
				emitter.onNext(1);
				emitter.onNext(2);
				emitter.onNext(3);
			}
		});

		o1.map(new Function<Integer, String>() {

			@Override
			public String apply(Integer t) throws Exception {
				// TODO Auto-generated method stub
				return "this is map result > " + t;
			}

		}).subscribe(new Observer<String>() { //Observer为接收器

			@Override
			public void onSubscribe(Disposable d) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onNext(String t) {
				// TODO Auto-generated method stub
				System.out.println(t + "");
			}

			@Override
			public void onError(Throwable e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
