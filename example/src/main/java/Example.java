
import fits.jufgon.util.function.FuncUtils;

import lombok.val;
import lombok.Value;

public class Example {
	public static void main(String... args) {

		val fc1 = FuncUtils.<String, Integer, Integer>curry("test data"::lastIndexOf);

		System.out.println(fc1.apply("d").apply(0));
		System.out.println(fc1.apply("d").apply(10));

		val fc2 = FuncUtils.<String, Integer, Data, Integer>curry(Example::sample);

		fc2.apply("sample").apply(100).apply(new Data("a", 5));

		System.out.println("--------");

		val fp1 = FuncUtils.<String, Integer, Integer>partial("test data"::lastIndexOf, "d");

		System.out.println(fp1.apply(0));
		System.out.println(fp1.apply(10));

		val fp2 = FuncUtils.<String, Integer, Data, Integer>partial(Example::sample, "sample2");

		fp2.apply(200).apply(new Data("b", 3));

		System.out.println("--------");

		val cp1 = FuncUtils.<String, Integer, Data>partial(Example::sample2, "consume", 30);

		cp1.accept(new Data("abc", 6));
	}

	private static int sample(String a1, int a2, Data a3) {
		System.out.printf("sample: %s, %s, %s \n", a1, a2, a3);
		return 0;
	}

	private static void sample2(String a1, int a2, Data a3) {
		System.out.printf("sample2: %s, %s, %s \n", a1, a2, a3);
	}


	@Value
	private static class Data {
		String name;
		int value;
	}
}