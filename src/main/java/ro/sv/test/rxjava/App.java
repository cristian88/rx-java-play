package ro.sv.test.rxjava;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {

		IntegerObserver observer = new IntegerObserver();
		IntegerObserver anotherObserver = new IntegerObserver();
		Observable<Integer> classicSubject = Observable.unsafeCreate(new IntegerEmitter());
		//classicSubject.safeSubscribe(observer);
		
		System.out.println("BehaviorSubject start");
		BehaviorSubject<Integer> behaviorSubject = BehaviorSubject.createDefault(1);
		behaviorSubject.subscribe(observer);
		behaviorSubject.onNext(2);
		behaviorSubject.onNext(3);
		System.out.println("BehaviorSubject stop");
		behaviorSubject.subscribe(anotherObserver);
		
		
	}
}