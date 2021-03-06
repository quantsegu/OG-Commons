/**
 * Copyright (C) 2009 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.collect.tuple;

import java.io.Serializable;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanBuilder;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableList;

/**
 * An immutable pair consisting of two elements.
 * <p>
 * This implementation refers to the elements as 'first' and 'second'.
 * The elements cannot be null.
 * <p>
 * Although the implementation is immutable, there is no restriction on the objects
 * that may be stored. If mutable objects are stored in the pair, then the pair itself
 * effectively becomes mutable.
 * <p>
 * Some primitive specializations of this class are provided, such as {@link DoublesPair}.
 * <p>
 * This class is immutable and thread-safe if the stored objects are immutable.
 *
 * @param <A> the first element type
 * @param <B> the second element type
 */
@BeanDefinition(builderScope = "private")
public final class Pair<A, B>
    implements ImmutableBean, Tuple, Comparable<Pair<A, B>>, Serializable {

  /**
   * The first element in this pair.
   */
  @PropertyDefinition(validate = "notNull")
  private final A first;
  /**
   * The second element in this pair.
   */
  @PropertyDefinition(validate = "notNull")
  private final B second;

  //-------------------------------------------------------------------------
  /**
   * Obtains a pair inferring the types.
   * 
   * @param <A> the first element type
   * @param <B> the second element type
   * @param first  the first element
   * @param second  the second element
   * @return a pair formed from the two parameters
   */
  public static <A, B> Pair<A, B> of(A first, B second) {
    return new Pair<>(first, second);
  }

  //-------------------------------------------------------------------------
  /**
   * Gets the number of elements held by this pair.
   * 
   * @return size 2
   */
  @Override
  public int size() {
    return 2;
  }

  /**
   * Gets the elements from this pair as a list.
   * <p>
   * The list returns each element in the pair in order.
   * 
   * @return the elements as an immutable list
   */
  @Override
  public ImmutableList<Object> elements() {
    return ImmutableList.of(first, second);
  }

  //-------------------------------------------------------------------------
  /**
   * Compares the pair based on the first element followed by the second element.
   * <p>
   * The element types must be {@code Comparable}.
   * 
   * @param other  the other pair
   * @return negative if this is less, zero if equal, positive if greater
   * @throws ClassCastException if either object is not comparable
   */
  @Override
  public int compareTo(Pair<A, B> other) {
    return ComparisonChain.start()
        .compare((Comparable<?>) first, (Comparable<?>) other.first)
        .compare((Comparable<?>) second, (Comparable<?>) other.second)
        .result();
  }

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

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code Pair}.
   * @return the meta-bean, not null
   */
  @SuppressWarnings("rawtypes")
  public static Pair.Meta meta() {
    return Pair.Meta.INSTANCE;
  }

  /**
   * The meta-bean for {@code Pair}.
   * @param <R>  the first generic type
   * @param <S>  the second generic type
   * @param cls1  the first generic type
   * @param cls2  the second generic type
   * @return the meta-bean, not null
   */
  @SuppressWarnings("unchecked")
  public static <R, S> Pair.Meta<R, S> metaPair(Class<R> cls1, Class<S> cls2) {
    return Pair.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(Pair.Meta.INSTANCE);
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  private Pair(
      A first,
      B second) {
    JodaBeanUtils.notNull(first, "first");
    JodaBeanUtils.notNull(second, "second");
    this.first = first;
    this.second = second;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Pair.Meta<A, B> metaBean() {
    return Pair.Meta.INSTANCE;
  }

  @Override
  public <R> Property<R> property(String propertyName) {
    return metaBean().<R>metaProperty(propertyName).createProperty(this);
  }

  @Override
  public Set<String> propertyNames() {
    return metaBean().metaPropertyMap().keySet();
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
   * @return the value of the property, not null
   */
  public B getSecond() {
    return second;
  }

  //-----------------------------------------------------------------------
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      Pair<?, ?> other = (Pair<?, ?>) obj;
      return JodaBeanUtils.equal(getFirst(), other.getFirst()) &&
          JodaBeanUtils.equal(getSecond(), other.getSecond());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(getFirst());
    hash = hash * 31 + JodaBeanUtils.hashCode(getSecond());
    return hash;
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code Pair}.
   * @param <A>  the type
   * @param <B>  the type
   */
  public static final class Meta<A, B> extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    @SuppressWarnings("rawtypes")
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code first} property.
     */
    @SuppressWarnings({"unchecked", "rawtypes" })
    private final MetaProperty<A> first = (DirectMetaProperty) DirectMetaProperty.ofImmutable(
        this, "first", Pair.class, Object.class);
    /**
     * The meta-property for the {@code second} property.
     */
    @SuppressWarnings({"unchecked", "rawtypes" })
    private final MetaProperty<B> second = (DirectMetaProperty) DirectMetaProperty.ofImmutable(
        this, "second", Pair.class, Object.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "first",
        "second");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 97440432:  // first
          return first;
        case -906279820:  // second
          return second;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends Pair<A, B>> builder() {
      return new Pair.Builder<A, B>();
    }

    @SuppressWarnings({"unchecked", "rawtypes" })
    @Override
    public Class<? extends Pair<A, B>> beanType() {
      return (Class) Pair.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code first} property.
     * @return the meta-property, not null
     */
    public MetaProperty<A> first() {
      return first;
    }

    /**
     * The meta-property for the {@code second} property.
     * @return the meta-property, not null
     */
    public MetaProperty<B> second() {
      return second;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 97440432:  // first
          return ((Pair<?, ?>) bean).getFirst();
        case -906279820:  // second
          return ((Pair<?, ?>) bean).getSecond();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      metaProperty(propertyName);
      if (quiet) {
        return;
      }
      throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
    }

  }

  //-----------------------------------------------------------------------
  /**
   * The bean-builder for {@code Pair}.
   * @param <A>  the type
   * @param <B>  the type
   */
  private static final class Builder<A, B> extends DirectFieldsBeanBuilder<Pair<A, B>> {

    private A first;
    private B second;

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case 97440432:  // first
          return first;
        case -906279820:  // second
          return second;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Builder<A, B> set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case 97440432:  // first
          this.first = (A) newValue;
          break;
        case -906279820:  // second
          this.second = (B) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public Builder<A, B> set(MetaProperty<?> property, Object value) {
      super.set(property, value);
      return this;
    }

    @Override
    public Builder<A, B> setString(String propertyName, String value) {
      setString(meta().metaProperty(propertyName), value);
      return this;
    }

    @Override
    public Builder<A, B> setString(MetaProperty<?> property, String value) {
      super.setString(property, value);
      return this;
    }

    @Override
    public Builder<A, B> setAll(Map<String, ? extends Object> propertyValueMap) {
      super.setAll(propertyValueMap);
      return this;
    }

    @Override
    public Pair<A, B> build() {
      return new Pair<A, B>(
          first,
          second);
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(96);
      buf.append("Pair.Builder{");
      buf.append("first").append('=').append(JodaBeanUtils.toString(first)).append(',').append(' ');
      buf.append("second").append('=').append(JodaBeanUtils.toString(second));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
