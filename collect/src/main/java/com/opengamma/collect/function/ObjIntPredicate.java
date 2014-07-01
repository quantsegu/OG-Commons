/**
 * Copyright (C) 2014 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.collect.function;

import java.util.Objects;
import java.util.function.BiPredicate;

/**
 * A predicate of two arguments - one object and one {@code int}.
 * <p>
 * This takes two arguments and returns a {@code boolean} result.
 *
 * @param <T> the type of the object parameter
 * @see BiPredicate
 */
@FunctionalInterface
public interface ObjIntPredicate<T> {

  /**
   * Evaluates the predicate.
   *
   * @param t  the first argument
   * @param u  the second argument
   * @return true if the arguments match the predicate
   */
  boolean test(T t, int u);

  /**
   * Returns a new predicate that returns true if both predicates return true.
   * <p>
   * The second predicate is only invoked if the first returns true.
   *
   * @param other  the second predicate
   * @return the combined predicate, "this AND that"
   * @throws NullPointerException if the other predicate is null
   */
  default ObjIntPredicate<T> and(ObjIntPredicate<? super T> other) {
      Objects.requireNonNull(other);
      return (T t, int u) -> test(t, u) && other.test(t, u);
  }

  /**
   * Returns a new predicate that returns true if either predicates returns true.
   * <p>
   * The second predicate is only invoked if the first returns false.
   *
   * @param other  the second predicate
   * @return the combined predicate, "this OR that"
   * @throws NullPointerException if the other predicate is null
   */
  default ObjIntPredicate<T> or(ObjIntPredicate<? super T> other) {
      Objects.requireNonNull(other);
      return (T t, int u) -> test(t, u) || other.test(t, u);
  }

  /**
   * Returns a new predicate that negates the result of this predicate.
   *
   * @return the predicate, "NOT this"
   */
  default ObjIntPredicate<T> negate() {
      return (T t, int u) -> !test(t, u);
  }

}
