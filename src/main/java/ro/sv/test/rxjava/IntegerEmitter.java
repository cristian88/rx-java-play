package ro.sv.test.rxjava;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class IntegerEmitter implements ObservableSource<Integer> {

	public void subscribe(Observer<? super Integer> observer) {

		observer.onSubscribe(new Disposable() {
			public boolean isDisposed() {
				return false;
			}

			public void dispose() {
				System.out.println("Going to dispose resource");
			}
		});

		for (int i = 0; i < 5; i++) {
			observer.onNext(i);
		}

		observer.onComplete();
	}
}
