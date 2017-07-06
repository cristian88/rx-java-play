package ro.sv.test.rxjava;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class IntegerObserver implements Observer<Integer> {
	public void onComplete() {
		System.out.println("Subject completed work");
	}

	public void onError(Throwable arg0) {
		System.out.println("Subject send error");
	}

	public void onNext(Integer arg0) {
		System.out.println("Received " + arg0);
	}

	public void onSubscribe(Disposable arg0) {
		System.out.println("Just subscried to subject");
	}
}