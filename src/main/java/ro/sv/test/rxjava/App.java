package ro.sv.test.rxjava;

import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.ReplaySubject;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {

		IntegerObserver observer = new IntegerObserver("First Observer");
		IntegerObserver secondObserver = new IntegerObserver("Second Observer");
		// Observable<Integer> classicSubject = Observable.unsafeCreate(new
		// IntegerEmitter());
		// classicSubject.safeSubscribe(observer);

		createBehaviourSubject(observer, secondObserver);

		createReplaySubject(observer, secondObserver);

		createAsynchSubject(observer, secondObserver);
	}

	private static void createAsynchSubject(IntegerObserver observer, IntegerObserver secondObserver) {

		System.out.println(
				"AsyncSubject publishes only the last item observed to each Observer that has subscribed when the Observable completes:");

		AsyncSubject<Integer> asyncSubject = AsyncSubject.create();
		asyncSubject.onNext(1);
		asyncSubject.onNext(2);
		asyncSubject.onNext(3);

		asyncSubject.subscribe(observer);
		asyncSubject.subscribe(secondObserver);
	}

	private static void createBehaviourSubject(IntegerObserver observer, IntegerObserver secondObserver) {
		System.out.println(
				"BehaviorSubject is a subject that emits the most recent item it has observed and all subsequent observed items to each subscribed item");
		BehaviorSubject<Integer> behaviorSubject = BehaviorSubject.createDefault(1);
		behaviorSubject.subscribe(observer);
		behaviorSubject.onNext(2);
		behaviorSubject.onNext(3);
		behaviorSubject.subscribe(secondObserver);
	}

	private static void createReplaySubject(IntegerObserver observer, IntegerObserver secondObserver) {
		System.out.println(
				"ReplaySubject  buffers all items it observes and replays them to any Observer that subscribes:");
		ReplaySubject<Integer> replaySubject = ReplaySubject.create();
		replaySubject.onNext(1);
		replaySubject.onNext(2);
		replaySubject.onNext(3);
		replaySubject.onNext(4);

		replaySubject.subscribe(observer);
		replaySubject.onNext(5);
		replaySubject.subscribe(secondObserver);
	}
}