/**
 * Copyright (C) 2014 - present by OpenGamma Inc. and the OpenGamma group of companies
 * 
 * Please see distribution for license.
 */
package com.opengamma.basics.date;

import java.time.LocalDate;
import java.time.Period;

import org.joda.convert.FromString;
import org.joda.convert.ToString;

import com.opengamma.collect.ArgChecker;
import com.opengamma.collect.named.ExtendedEnum;
import com.opengamma.collect.named.Named;

/**
 * A convention defining how a period is added to a date.
 * <p>
 * The purpose of this convention is to define how to handle the addition of a period.
 * The default implementations include two different end-of-month rules.
 * The convention is generally only applicable for month-based periods.
 * <p>
 * The most common implementations are provided in {@link PeriodAdditionConventions}.
 * Additional implementations may be added by implementing this interface.
 * <p>
 * All implementations of this interface must be immutable and thread-safe.
 */
public interface PeriodAdditionConvention
    extends Named {

  /**
   * Obtains a {@code PeriodAdditionConvention} from a unique name.
   * 
   * @param uniqueName  the unique name
   * @return the addition convention
   * @throws IllegalArgumentException if the name is not known
   */
  @FromString
  public static PeriodAdditionConvention of(String uniqueName) {
    ArgChecker.notNull(uniqueName, "uniqueName");
    return extendedEnum().lookup(uniqueName);
  }

  /**
   * Gets the extended enum helper.
   * <p>
   * This helper allows instances of {@code PeriodAdditionConvention} to be lookup up.
   * It also provides the complete set of available instances.
   * 
   * @return the extended enum helper
   */
  public static ExtendedEnum<PeriodAdditionConvention> extendedEnum() {
    return PeriodAdditionConventions.ENUM_LOOKUP;
  }

  //-------------------------------------------------------------------------
  /**
   * Adjusts the base date, adding the period and applying the convention rule.
   * <p>
   * The adjustment occurs in two steps.
   * First, the period is added to the based date to create the end date.
   * Second, the end date is adjusted by the convention rules.
   * 
   * @param baseDate  the base date to add to
   * @param period  the period to add
   * @param calendar  the holiday calendar to use
   * @return the adjusted date
   */
  public LocalDate adjust(LocalDate baseDate, Period period, HolidayCalendar calendar);

  /**
   * Checks whether the convention requires a month-based period.
   * <p>
   * A month-based period contains only months and/or years, and not days.
   * 
   * @return true if the convention requires a month-based period
   */
  public boolean isMonthBased();

  /**
   * Gets the name that uniquely identifies this convention.
   * <p>
   * This name is used in serialization and can be parsed using {@link #of(String)}.
   * 
   * @return the unique name
   */
  @ToString
  @Override
  public String getName();

}
