package fits.jufgon.util.function;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FuncUtils {
	/**
	 *
	 * @param func
	 * @param <T>
	 * @param <U>
	 * @param <R>
	 * @return
	 */
	public static <T, U, R> Function<T, Function<U, R>> curry(BiFunction<T, U, R> func) {
		return t -> u -> func.apply(t, u);
	}

	/**
	 *
	 * @param func
	 * @param <S>
	 * @param <T>
	 * @param <U>
	 * @param <R>
	 * @return
	 */
	public static <S, T, U, R> Function<S, Function<T, Function<U, R>>> curry(F3<S, T, U, R> func) {
		return s -> t -> u -> func.apply(s, t, u);
	}

	/**
	 *
	 * @param func
	 * @param <Q>
	 * @param <S>
	 * @param <T>
	 * @param <U>
	 * @param <R>
	 * @return
	 */
	public static <Q, S, T, U, R> Function<Q, Function<S, Function<T, Function<U, R>>>> curry(F4<Q, S, T, U, R> func) {
		return q -> s -> t -> u -> func.apply(q, s, t, u);
	}

	/**
	 *
	 * @param func
	 * @param <T>
	 * @param <U>
	 * @return
	 */
	public static <T, U> Function<T, Consumer<U>> curry(BiConsumer<T, U> func) {
		return t -> u -> func.accept(t, u);
	}

	/**
	 *
	 * @param func
	 * @param <S>
	 * @param <T>
	 * @param <U>
	 * @return
	 */
	public static <S, T, U> Function<S, Function<T, Consumer<U>>> curry(C3<S, T, U> func) {
		return s -> t -> u -> func.accept(s, t, u);
	}

	/**
	 *
	 * @param func
	 * @param <Q>
	 * @param <S>
	 * @param <T>
	 * @param <U>
	 * @return
	 */
	public static <Q, S, T, U> Function<Q, Function<S, Function<T, Consumer<U>>>> curry(C4<Q, S, T, U> func) {
		return q -> s -> t -> u -> func.accept(q, s, t, u);
	}

	/**
	 *
	 * @param func
	 * @param <T>
	 * @param <U>
	 * @return
	 */
	public static <T, U> Function<T, Predicate<U>> curry(BiPredicate<T, U> func) {
		return t -> u -> func.test(t, u);
	}

	/**
	 *
	 * @param func
	 * @param <S>
	 * @param <T>
	 * @param <U>
	 * @return
	 */
	public static <S, T, U> Function<S, Function<T, Predicate<U>>> curry(P3<S, T, U> func) {
		return s -> t -> u -> func.test(s, t, u);
	}

	/**
	 *
	 * @param func
	 * @param <Q>
	 * @param <S>
	 * @param <T>
	 * @param <U>
	 * @return
	 */
	public static <Q, S, T, U> Function<Q, Function<S, Function<T, Predicate<U>>>> curry(P4<Q, S, T, U> func) {
		return q -> s -> t -> u -> func.test(q, s, t, u);
	}

	/**
	 *
	 * @param func
	 * @param t
	 * @param <T>
	 * @param <U>
	 * @param <R>
	 * @return
	 */
	public static <T, U, R> Function<U, R> partial(BiFunction<T, U, R> func, final T t) {
		return curry(func).apply(t);
	}

	/**
	 *
	 * @param func
	 * @param s
	 * @param <S>
	 * @param <T>
	 * @param <U>
	 * @param <R>
	 * @return
	 */
	public static <S, T, U, R> Function<T, Function<U, R>> partial(F3<S, T, U, R> func, final S s) {
		return curry(func).apply(s);
	}

	/**
	 *
	 * @param func
	 * @param s
	 * @param t
	 * @param <S>
	 * @param <T>
	 * @param <U>
	 * @param <R>
	 * @return
	 */
	public static <S, T, U, R> Function<U, R> partial(F3<S, T, U, R> func, final S s, final T t) {
		return partial(func, s).apply(t);
	}

	/**
	 *
	 * @param func
	 * @param q
	 * @param <Q>
	 * @param <S>
	 * @param <T>
	 * @param <U>
	 * @param <R>
	 * @return
	 */
	public static <Q, S, T, U, R> Function<S, Function<T, Function<U, R>>> partial(F4<Q, S, T, U, R> func, Q q) {
		return curry(func).apply(q);
	}

	/**
	 *
	 * @param func
	 * @param q
	 * @param s
	 * @param <Q>
	 * @param <S>
	 * @param <T>
	 * @param <U>
	 * @param <R>
	 * @return
	 */
	public static <Q, S, T, U, R> Function<T, Function<U, R>> partial(F4<Q, S, T, U, R> func, Q q, S s) {
		return partial(func, q).apply(s);
	}

	/**
	 *
	 * @param func
	 * @param q
	 * @param s
	 * @param t
	 * @param <Q>
	 * @param <S>
	 * @param <T>
	 * @param <U>
	 * @param <R>
	 * @return
	 */
	public static <Q, S, T, U, R> Function<U, R> partial(F4<Q, S, T, U, R> func, Q q, S s, T t) {
		return partial(func, q, s).apply(t);
	}


	/**
	 *
	 * @param func
	 * @param t
	 * @param <T>
	 * @param <U>
	 * @return
	 */
	public static <T, U> Consumer<U> partial(BiConsumer<T, U> func, T t) {
		return curry(func).apply(t);
	}

	/**
	 *
	 * @param func
	 * @param s
	 * @param t
	 * @param <S>
	 * @param <T>
	 * @param <U>
	 * @return
	 */
	public static <S, T, U> Consumer<U> partial(C3<S, T, U> func, S s, T t) {
		return partial(func, s).apply(t);
	}

	/**
	 *
	 * @param func
	 * @param s
	 * @param <S>
	 * @param <T>
	 * @param <U>
	 * @return
	 */
	public static <S, T, U> Function<T, Consumer<U>> partial(C3<S, T, U> func, S s) {
		return curry(func).apply(s);
	}

	/**
	 *
	 * @param func
	 * @param q
	 * @param s
	 * @param t
	 * @param <Q>
	 * @param <S>
	 * @param <T>
	 * @param <U>
	 * @return
	 */
	public static <Q, S, T, U> Consumer<U> partial(C4<Q, S, T, U> func, Q q, S s, T t) {
		return partial(func, q, s).apply(t);
	}

	/**
	 *
	 * @param func
	 * @param q
	 * @param s
	 * @param <Q>
	 * @param <S>
	 * @param <T>
	 * @param <U>
	 * @return
	 */
	public static <Q, S, T, U> Function<T, Consumer<U>> partial(C4<Q, S, T, U> func, Q q, S s) {
		return partial(func, q).apply(s);
	}

	/**
	 *
	 * @param func
	 * @param q
	 * @param <Q>
	 * @param <S>
	 * @param <T>
	 * @param <U>
	 * @return
	 */
	public static <Q, S, T, U> Function<S, Function<T, Consumer<U>>> partial(C4<Q, S, T, U> func, Q q) {
		return curry(func).apply(q);
	}

	/**
	 *
	 * @param func
	 * @param t
	 * @param <T>
	 * @param <U>
	 * @return
	 */
	public static <T, U> Predicate<U> partial(BiPredicate<T, U> func, T t) {
		return curry(func).apply(t);
	}

	/**
	 *
	 * @param func
	 * @param s
	 * @param t
	 * @param <S>
	 * @param <T>
	 * @param <U>
	 * @return
	 */
	public static <S, T, U> Predicate<U> partial(P3<S, T, U> func, S s, T t) {
		return partial(func, s).apply(t);
	}

	/**
	 *
	 * @param func
	 * @param s
	 * @param <S>
	 * @param <T>
	 * @param <U>
	 * @return
	 */
	public static <S, T, U> Function<T, Predicate<U>> partial(P3<S, T, U> func, S s) {
		return curry(func).apply(s);
	}

	/**
	 *
	 * @param func
	 * @param q
	 * @param s
	 * @param t
	 * @param <Q>
	 * @param <S>
	 * @param <T>
	 * @param <U>
	 * @return
	 */
	public static <Q, S, T, U> Predicate<U> partial(P4<Q, S, T, U> func, Q q, S s, T t) {
		return partial(func, q, s).apply(t);
	}

	/**
	 *
	 * @param func
	 * @param q
	 * @param s
	 * @param <Q>
	 * @param <S>
	 * @param <T>
	 * @param <U>
	 * @return
	 */
	public static <Q, S, T, U> Function<T, Predicate<U>> partial(P4<Q, S, T, U> func, Q q, S s) {
		return partial(func, q).apply(s);
	}

	/**
	 *
	 * @param func
	 * @param q
	 * @param <Q>
	 * @param <S>
	 * @param <T>
	 * @param <U>
	 * @return
	 */
	public static <Q, S, T, U> Function<S, Function<T, Predicate<U>>> partial(P4<Q, S, T, U> func, Q q) {
		return curry(func).apply(q);
	}


	/**
	 *
	 * @param <S>
	 * @param <T>
	 * @param <U>
	 * @param <R>
	 */
	public static interface F3<S, T, U, R> {
		R apply(S s, T t, U u);
	}

	/**
	 *
	 * @param <Q>
	 * @param <S>
	 * @param <T>
	 * @param <U>
	 * @param <R>
	 */
	public static interface F4<Q, S, T, U, R> {
		R apply(Q q, S s, T t, U u);
	}


	/**
	 *
	 * @param <S>
	 * @param <T>
	 * @param <U>
	 */
	public static interface C3<S, T, U> {
		void accept(S s, T t, U u);
	}

	/**
	 *
	 * @param <Q>
	 * @param <S>
	 * @param <T>
	 * @param <U>
	 */
	public static interface C4<Q, S, T, U> {
		void accept(Q q, S s, T t, U u);
	}


	/**
	 *
	 * @param <S>
	 * @param <T>
	 * @param <U>
	 */
	public static interface P3<S, T, U> {
		boolean test(S s, T t, U u);
	}

	/**
	 *
	 * @param <Q>
	 * @param <S>
	 * @param <T>
	 * @param <U>
	 */
	public static interface P4<Q, S, T, U> {
		boolean test(Q q, S s, T t, U u);
	}
}
