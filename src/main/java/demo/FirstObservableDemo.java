package demo;


import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

public class FirstObservableDemo {


	public static void main(String[] args) {

		List<Integer> items = initIntSequence(10);

		// Observable, 10 items

		Observable.from(items).subscribe(System.out::println);

		// src/test/java -> RxObservableVerification

		// log demand with doOnRequest

		// back-pressure: experiment with request(n) in createSubscriber

		// Observable, 10000 items

	}

	private static List<Integer> initIntSequence(long itemCount) {
		List<Integer> items = new ArrayList<>();
		for(int i = 1; i <= itemCount ; i++){
			items.add(i);
		}
		return items;
	}

	@SuppressWarnings("unused")
	private static Subscriber<Integer> createSubscriber() {

		return new Subscriber<Integer>() {


			@Override
			public void onStart() {
				System.out.println("onStart");
				request(1);
			}

			@Override
			public void onNext(Integer data) {
				System.out.println(data);
				request(1);
			}

			@Override
			public void onError(Throwable error) {
				System.out.println("onError: " + error);
			}

			@Override
			public void onCompleted() {
				System.out.println("onComplete");
			}
		};
	}

}
