/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 * 
 * Please see distribution for license.
 */
package com.opengamma.basics.index;

import org.joda.convert.FromString;
import org.joda.convert.ToString;

import com.opengamma.basics.currency.Currency;
import com.opengamma.basics.location.Country;
import com.opengamma.basics.schedule.Frequency;
import com.opengamma.collect.ArgChecker;
import com.opengamma.collect.named.ExtendedEnum;
import com.opengamma.collect.named.Named;

/**
 * An index of prices.
 * <p>
 * A price index is a normalized average of the prices of goods and/or services.
 * Well-known price indices are published by Governments, such as the Consumer Price Index.
 * The annualized percentage change in the index is a measure of inflation.
 * <p>
 * This interface represents a price index for a specific region.
 * The index is typically published monthly in arrears, however some regions
 * choose quarterly publication.
 * <p>
 * The most common implementations are provided in {@link PriceIndices}.
 * <p>
 * All implementations of this interface must be immutable and thread-safe.
 */
public interface PriceIndex
    extends Index, Named {

  /**
   * Obtains an {@code PriceIndex} from a unique name.
   * 
   * @param uniqueName  the unique name
   * @return the index
   * @throws IllegalArgumentException if the name is not known
   */
  @FromString
  public static PriceIndex of(String uniqueName) {
    ArgChecker.notNull(uniqueName, "uniqueName");
    return extendedEnum().lookup(uniqueName);
  }

  /**
   * Gets the extended enum helper.
   * <p>
   * This helper allows instances of {@code PriceIndex} to be lookup up.
   * It also provides the complete set of available instances.
   * 
   * @return the extended enum helper
   */
  public static ExtendedEnum<PriceIndex> extendedEnum() {
    return PriceIndices.ENUM_LOOKUP;
  }

  //-------------------------------------------------------------------------
  /**
   * Gets the region that the index is defined for.
   * 
   * @return the region of the index
   */
  public abstract Country getRegion();

  /**
   * Gets the currency of the index.
   * 
   * @return the currency of the index
   */
  public abstract Currency getCurrency();

  /**
   * Gets the frequency that the index is published.
   * <p>
   * Most price indices are published monthly, but some are published quarterly.
   * 
   * @return the frequency of publication of the index
   */
  public abstract Frequency getPublicationFrequency();

  //-------------------------------------------------------------------------
  /**
   * Gets the name that uniquely identifies this index.
   * <p>
   * This name is used in serialization and can be parsed using {@link #of(String)}.
   * 
   * @return the unique name
   */
  @ToString
  @Override
  public abstract String getName();

}
