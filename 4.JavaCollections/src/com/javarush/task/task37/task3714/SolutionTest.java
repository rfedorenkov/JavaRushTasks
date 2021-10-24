package com.javarush.task.task37.task3714;

import org.junit.Assert;
import org.junit.Test;

import static com.javarush.task.task37.task3714.Solution.romanToInteger;

public class SolutionTest {

    @Test
    public void romanToIntegerTestOne() {
        Assert.assertEquals(romanToInteger("I"), 1);
    }

    @Test
    public void romanToIntegerTestFive() {
        Assert.assertEquals(romanToInteger("V"), 5);
    }

    @Test
    public void romanToIntegerTestSix() {
        Assert.assertEquals(romanToInteger("VII"), 7);
    }

    @Test
    public void romanToIntegerTestEight() {
        Assert.assertEquals(8, romanToInteger("VIII"));
    }

    @Test
    public void romanToIntegerTestFour() {
        Assert.assertEquals(4, romanToInteger("IV"));
    }

    @Test
    public void romanToIntegerTestOther() {
        Assert.assertEquals(romanToInteger("IX"), 9);
        Assert.assertEquals(romanToInteger("XV"), 15);
        Assert.assertEquals(romanToInteger("XIX"), 19);
        Assert.assertEquals(romanToInteger("XL"), 40);
        Assert.assertEquals(romanToInteger("XLII"), 42);
        Assert.assertEquals(romanToInteger("LX"), 60);
        Assert.assertEquals(romanToInteger("LXXX"), 80);
        Assert.assertEquals(romanToInteger("LXXXIII"), 83);
        Assert.assertEquals(romanToInteger("XCIV"), 94);
        Assert.assertEquals(romanToInteger("XC"), 90);
        Assert.assertEquals(romanToInteger("CL"), 150);
        Assert.assertEquals(romanToInteger("CCLXXXIII"), 283);
        Assert.assertEquals(romanToInteger("DCCC"), 800);
        Assert.assertEquals(romanToInteger("MCMLXXXVIII"), 1988);
        Assert.assertEquals(romanToInteger("MMDCLXXXIII"), 2683);
        Assert.assertEquals(romanToInteger("MMDDCCLLXXVVII"), 3332);
        Assert.assertEquals(romanToInteger("MMMD"), 3500);
    }

}