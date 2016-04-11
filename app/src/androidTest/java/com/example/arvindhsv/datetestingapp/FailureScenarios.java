package com.example.arvindhsv.datetestingapp;

public class FailureScenarios {
    public void monthsEndValueFromAugToNov() {}
    public void febLessThan29ForNonLeapYear() {}
    public void datesOfCurrentYearMonthButDateGreaterThanToday() {}
    public void withBlankValueForDateMonthAndYear() {}
    public void valueMoreThan3031ForDate() {}
    public void monthValueGreaterThan12() {}

    public void canItAcceptValuesLike3DigitsForYear() {}
    public void canGivingEmptyDateMonthYearBeRestricted() {}
}