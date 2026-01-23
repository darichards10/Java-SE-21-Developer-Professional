package se21;

public class Main {

	public static void main(String[] args) {
		Decisions.compareIntegers(1);
		Decisions.printIntegersGreaterThan5(6);
		Decisions.printOnlyIntegers(-200);
		Decisions.printAnimalBest("Sancha");
		Decisions.shouldGetACoat(Season.FALL);

		Decisions.printDetails(5);
		Decisions.printDetails(5.0);
		Decisions.printDetails(5f);

		Decisions.getTrainer(5);

		Decisions.doWhile();
		Decisions.breakLoop();
		Decisions.continueLoop();
		Decisions.sortStringList();

		Concurrency.printListWithParallelStream();
		Concurrency.printListWithStream();

		SB.objectExample();
		SB.commonMethods();
		SB.compilationEquality();

		ArraysDemo.equality();
		ArraysDemo.addingToNew();

		MathAPI.bigIntOperations();

		DateTimeAPI.examples();
		DateTimeAPI.localExamples();
		DateTimeAPI.zonedExamples();

		Methods.zooAnimalCheckup(true);

		Methods.walk(1, new int[] { 1, 2, 3 });
		Methods.walk(4, 5, 6);
		Methods.walk(7);
		Methods.walk(1, new int[] { 1, 2, 3 });
		
		//varargs
		System.out.println(Methods.glide("a"));
		System.out.println(Methods.glide("a", "b"));
		System.out.println(Methods.glide("a", "b", "c"));

		new Methods();
	}

}
