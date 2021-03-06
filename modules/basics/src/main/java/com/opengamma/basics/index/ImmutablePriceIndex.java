/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 * 
 * Please see distribution for license.
 */
package com.opengamma.basics.index;

import java.io.Serializable;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
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

import com.opengamma.basics.currency.Currency;
import com.opengamma.basics.location.Country;
import com.opengamma.basics.schedule.Frequency;

/**
 * A price index implementation based on an immutable set of rules.
 * <p>
 * A standard immutable implementation of {@link PriceIndex}.
 * <p>
 * In most cases, applications should refer to indices by name, using {@link PriceIndex#of(String)}.
 * The named index will typically be resolved to an instance of this class.
 * As such, it is recommended to use the {@code PriceIndex} interface in application
 * code rather than directly referring to this class.
 */
@BeanDefinition
public final class ImmutablePriceIndex
    implements PriceIndex, ImmutableBean, Serializable {

  /**
   * The index name, such as 'GB-HICP'.
   */
  @PropertyDefinition(validate = "notEmpty", overrideGet = true)
  private final String name;
  /**
   * The region of the index.
   */
  @PropertyDefinition(validate = "notNull", overrideGet = true)
  private final Country region;
  /**
   * The currency of the index.
   */
  @PropertyDefinition(validate = "notNull", overrideGet = true)
  private final Currency currency;
  /**
   * The publication frequency of the index.
   * Most price indices are published monthly, but some are published quarterly.
   */
  @PropertyDefinition(validate = "notNull", overrideGet = true)
  private final Frequency publicationFrequency;

  //-------------------------------------------------------------------------
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj instanceof ImmutablePriceIndex) {
      return name.equals(((ImmutablePriceIndex) obj).name);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return name.hashCode();
  }

  //-------------------------------------------------------------------------
  /**
   * Returns the name of the index.
   * 
   * @return the name of the index
   */
  @Override
  public String toString() {
    return getName();
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code ImmutablePriceIndex}.
   * @return the meta-bean, not null
   */
  public static ImmutablePriceIndex.Meta meta() {
    return ImmutablePriceIndex.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(ImmutablePriceIndex.Meta.INSTANCE);
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static ImmutablePriceIndex.Builder builder() {
    return new ImmutablePriceIndex.Builder();
  }

  private ImmutablePriceIndex(
      String name,
      Country region,
      Currency currency,
      Frequency publicationFrequency) {
    JodaBeanUtils.notEmpty(name, "name");
    JodaBeanUtils.notNull(region, "region");
    JodaBeanUtils.notNull(currency, "currency");
    JodaBeanUtils.notNull(publicationFrequency, "publicationFrequency");
    this.name = name;
    this.region = region;
    this.currency = currency;
    this.publicationFrequency = publicationFrequency;
  }

  @Override
  public ImmutablePriceIndex.Meta metaBean() {
    return ImmutablePriceIndex.Meta.INSTANCE;
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
   * Gets the index name, such as 'GB-HICP'.
   * @return the value of the property, not empty
   */
  @Override
  public String getName() {
    return name;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the region of the index.
   * @return the value of the property, not null
   */
  @Override
  public Country getRegion() {
    return region;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the currency of the index.
   * @return the value of the property, not null
   */
  @Override
  public Currency getCurrency() {
    return currency;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the publication frequency of the index.
   * Most price indices are published monthly, but some are published quarterly.
   * @return the value of the property, not null
   */
  @Override
  public Frequency getPublicationFrequency() {
    return publicationFrequency;
  }

  //-----------------------------------------------------------------------
  /**
   * Returns a builder that allows this bean to be mutated.
   * @return the mutable builder, not null
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code ImmutablePriceIndex}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code name} property.
     */
    private final MetaProperty<String> name = DirectMetaProperty.ofImmutable(
        this, "name", ImmutablePriceIndex.class, String.class);
    /**
     * The meta-property for the {@code region} property.
     */
    private final MetaProperty<Country> region = DirectMetaProperty.ofImmutable(
        this, "region", ImmutablePriceIndex.class, Country.class);
    /**
     * The meta-property for the {@code currency} property.
     */
    private final MetaProperty<Currency> currency = DirectMetaProperty.ofImmutable(
        this, "currency", ImmutablePriceIndex.class, Currency.class);
    /**
     * The meta-property for the {@code publicationFrequency} property.
     */
    private final MetaProperty<Frequency> publicationFrequency = DirectMetaProperty.ofImmutable(
        this, "publicationFrequency", ImmutablePriceIndex.class, Frequency.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "name",
        "region",
        "currency",
        "publicationFrequency");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 3373707:  // name
          return name;
        case -934795532:  // region
          return region;
        case 575402001:  // currency
          return currency;
        case -1407208304:  // publicationFrequency
          return publicationFrequency;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public ImmutablePriceIndex.Builder builder() {
      return new ImmutablePriceIndex.Builder();
    }

    @Override
    public Class<? extends ImmutablePriceIndex> beanType() {
      return ImmutablePriceIndex.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code name} property.
     * @return the meta-property, not null
     */
    public MetaProperty<String> name() {
      return name;
    }

    /**
     * The meta-property for the {@code region} property.
     * @return the meta-property, not null
     */
    public MetaProperty<Country> region() {
      return region;
    }

    /**
     * The meta-property for the {@code currency} property.
     * @return the meta-property, not null
     */
    public MetaProperty<Currency> currency() {
      return currency;
    }

    /**
     * The meta-property for the {@code publicationFrequency} property.
     * @return the meta-property, not null
     */
    public MetaProperty<Frequency> publicationFrequency() {
      return publicationFrequency;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 3373707:  // name
          return ((ImmutablePriceIndex) bean).getName();
        case -934795532:  // region
          return ((ImmutablePriceIndex) bean).getRegion();
        case 575402001:  // currency
          return ((ImmutablePriceIndex) bean).getCurrency();
        case -1407208304:  // publicationFrequency
          return ((ImmutablePriceIndex) bean).getPublicationFrequency();
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
   * The bean-builder for {@code ImmutablePriceIndex}.
   */
  public static final class Builder extends DirectFieldsBeanBuilder<ImmutablePriceIndex> {

    private String name;
    private Country region;
    private Currency currency;
    private Frequency publicationFrequency;

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    private Builder(ImmutablePriceIndex beanToCopy) {
      this.name = beanToCopy.getName();
      this.region = beanToCopy.getRegion();
      this.currency = beanToCopy.getCurrency();
      this.publicationFrequency = beanToCopy.getPublicationFrequency();
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case 3373707:  // name
          return name;
        case -934795532:  // region
          return region;
        case 575402001:  // currency
          return currency;
        case -1407208304:  // publicationFrequency
          return publicationFrequency;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case 3373707:  // name
          this.name = (String) newValue;
          break;
        case -934795532:  // region
          this.region = (Country) newValue;
          break;
        case 575402001:  // currency
          this.currency = (Currency) newValue;
          break;
        case -1407208304:  // publicationFrequency
          this.publicationFrequency = (Frequency) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public Builder set(MetaProperty<?> property, Object value) {
      super.set(property, value);
      return this;
    }

    @Override
    public Builder setString(String propertyName, String value) {
      setString(meta().metaProperty(propertyName), value);
      return this;
    }

    @Override
    public Builder setString(MetaProperty<?> property, String value) {
      super.setString(property, value);
      return this;
    }

    @Override
    public Builder setAll(Map<String, ? extends Object> propertyValueMap) {
      super.setAll(propertyValueMap);
      return this;
    }

    @Override
    public ImmutablePriceIndex build() {
      return new ImmutablePriceIndex(
          name,
          region,
          currency,
          publicationFrequency);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the {@code name} property in the builder.
     * @param name  the new value, not empty
     * @return this, for chaining, not null
     */
    public Builder name(String name) {
      JodaBeanUtils.notEmpty(name, "name");
      this.name = name;
      return this;
    }

    /**
     * Sets the {@code region} property in the builder.
     * @param region  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder region(Country region) {
      JodaBeanUtils.notNull(region, "region");
      this.region = region;
      return this;
    }

    /**
     * Sets the {@code currency} property in the builder.
     * @param currency  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder currency(Currency currency) {
      JodaBeanUtils.notNull(currency, "currency");
      this.currency = currency;
      return this;
    }

    /**
     * Sets the {@code publicationFrequency} property in the builder.
     * @param publicationFrequency  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder publicationFrequency(Frequency publicationFrequency) {
      JodaBeanUtils.notNull(publicationFrequency, "publicationFrequency");
      this.publicationFrequency = publicationFrequency;
      return this;
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(160);
      buf.append("ImmutablePriceIndex.Builder{");
      buf.append("name").append('=').append(JodaBeanUtils.toString(name)).append(',').append(' ');
      buf.append("region").append('=').append(JodaBeanUtils.toString(region)).append(',').append(' ');
      buf.append("currency").append('=').append(JodaBeanUtils.toString(currency)).append(',').append(' ');
      buf.append("publicationFrequency").append('=').append(JodaBeanUtils.toString(publicationFrequency));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
