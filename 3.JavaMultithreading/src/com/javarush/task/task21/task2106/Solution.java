package com.javarush.task.task21.task2106;

import java.util.Date;
import java.util.Objects;

/**
 * Ошибка в equals/hashCode
 * Исправьте ошибки реализаций методов equals и hashCode для класса Solution.
 *
 *
 * Требования:
 * 1. Хешкоды одинаковых объектов должны быть равны.
 * 2. Метод equals должен проверять равен ли переданный объект равен текущему (сравнение через ==).
 * 3. Метод equals должен проверять является ли переданный объект объектом класса Solution.
 * 4. Метод equals должен проверять значения всех полей у переданного объекта и текущего
 * (учти что некоторые из них могут быть равны null).
 * 5. Должно быть обеспечено корректное поведение HashSet с типом элементов Solution.
 * 6. В классе Solution должен быть реализован метод hashCode.
*/

public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;

        Solution solution1 = (Solution) o;

        if (Double.compare(solution1.aDouble, aDouble) != 0) return false;
        if (anInt != solution1.anInt) return false;
        if (!Objects.equals(date, solution1.date)) return false;
        if (!Objects.equals(solution, solution1.solution)) return false;
        return Objects.equals(string, solution1.string);
    }


    @Override
    public int hashCode() {
        int result;
        long temp;
        result = anInt;
        result = 31 * result + (string != null ? string.hashCode() : 0);
        temp = aDouble != +0.0d ? Double.doubleToLongBits(aDouble) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (solution != null ? solution.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {

    }
}
