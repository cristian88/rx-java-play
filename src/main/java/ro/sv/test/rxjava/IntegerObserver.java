package ro.sv.test.rxjava;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class IntegerObserver implements Observer<Integer> {

	String observerName;

	public IntegerObserver(String observerName) {
		this.observerName = observerName;
	}

	public void onComplete() {
		System.out.println(observerName + " completed work");
	}

	public void onError(Throwable arg0) {
		System.out.println(observerName + " chaught error: " + arg0.getMessage());
		arg0.printStackTrace();
	}

	public void onNext(Integer arg0) {
		System.out.println(observerName + " received " + arg0);
	}

	public void onSubscribe(Disposable arg0) {
		System.out.println(observerName + " just subscribed to subject");
	}
}