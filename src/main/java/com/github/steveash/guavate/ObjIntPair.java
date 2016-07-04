/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.github.steveash.guavate;

import java.io.Serializable;

import org.apache.commons.lang3.tuple.Pair;

import com.google.common.base.Preconditions;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableList;

/**
 * An immutable pair consisting of an {@code Object} and an {@code int}.
 * <p>
 * This class is similar to {@link Pair} but includes a primitive element.
 * <p>
 * This class is immutable and thread-safe.
 *
 * @param <A> the type of the object
 */
public final class ObjIntPair<A> implements Comparable<ObjIntPair<A>>, Serializable {

  /**
   * The first element in this pair.
   */
  private final A first;

  /**
   * The second element in this pair.
   */
  private final int second;

  //-------------------------------------------------------------------------
  /**
   * Obtains an instance from an {@code Object} and an {@code int}.
   *
   * @param <A> the first element type
   * @param first  the first element
   * @param second  the second element
   * @return a pair formed from the two parameters
   */
  public static <A> ObjIntPair<A> of(A first, int second) {
    return new ObjIntPair<>(first, second);
  }

  /**
   * Obtains an instance from a {@code Pair}.
   *
   * @param <A> the first element type
   * @param pair  the pair to convert
   * @return a pair formed by extracting values from the pair
   */
  public static <A> ObjIntPair<A> ofPair(Pair<A, Integer> pair) {
    Preconditions.checkNotNull(pair, "pair");
    return new ObjIntPair<A>(pair.getLeft(), pair.getRight());
  }

  /**
   * Gets the elements from this pair as a list.
   * <p>
   * The list returns each element in the pair in order.
   *
   * @return the elements as an immutable list
   */
  public ImmutableList<Object> elements() {
    return ImmutableList.of(first, second);
  }

  //-------------------------------------------------------------------------
  /**
   * Converts this pair to an object-based {@code Pair}.
   *
   * @return the object-based pair
   */
  public Pair<A, Integer> toPair() {
    return Pair.of(first, second);
  }

  //-------------------------------------------------------------------------
  /**
   * Compares the pair based on the first element followed by the second element.
   * <p>
   * The first element must be {@code Comparable}.
   *
   * @param other  the other pair
   * @return negative if this is less, zero if equal, positive if greater
   * @throws ClassCastException if the object is not comparable
   */
  @Override
  public int compareTo(ObjIntPair<A> other) {
    return ComparisonChain.start()
        .compare((Comparable<?>) first, (Comparable<?>) other.first)
        .compare(second, other.second)
        .result();
  }

  //-------------------------------------------------------------------------
  /**
   * Gets the pair using a standard string format.
   * <p>
   * The standard format is '[$first, $second]'. Spaces around the values are trimmed.
   *
   * @return the pair as a string
   */
  @Override
  public String toString() {
    return new StringBuilder()
        .append('[')
        .append(first)
        .append(", ")
        .append(second)
        .append(']')
        .toString();
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  private ObjIntPair(
      A first,
      int second) {
    this.first = first;
    this.second = second;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the first element in this pair.
   * @return the value of the property, not null
   */
  public A getFirst() {
    return first;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the second element in this pair.
   * @return the value of the property
   */
  public int getSecond() {
    return second;
  }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObjIntPair<?> that = (ObjIntPair<?>) o;

        if (second != that.second) return false;
        return first != null ? first.equals(that.first) : that.first == null;
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + second;
        return result;
    }
}
