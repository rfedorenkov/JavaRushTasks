package com.javarush.task.task34.task3404;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleBinaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Рекурсия для мат. выражения
 * На вход подается строка - математическое выражение.
 * Выражение включает целые и дробные числа, скобки (), пробелы, знак отрицания -,
 * возведение в степень ^, sin(x), cos(x), tan(x)
 * Для sin(x), cos(x), tan(x) выражение внутри скобок считать градусами, например, cos(3 + 19*3)=0.5
 * Степень задается так: a^(1+3) и так a^4, что эквивалентно a*a*a*a.
 * С помощью рекурсии вычислить выражение и количество математических операций. Вывести через пробел результат в консоль.
 * Результат выводить с точностью до двух знаков, для 0.33333 вывести 0.33, использовать стандартный принцип округления.
 * Знак отрицания перед числом также считать математической операцией.
 * Не создавай в классе Solution дополнительные поля.
 * Не пиши косвенную рекурсию.
 *
 * Пример, состоящий из операций sin * - + * +:
 * sin(2*(-5+1.5*4)+28)
 * Результат:
 * 0.5 6
 *
 * Пример, состоящий из операций tan ^:
 * tan(2025 ^ 0.5)
 * Результат:
 * 1 2
 *
 *
 * Requirements:
 * 1. В классе Solution не должны быть созданы дополнительные поля.
 * 2. Метод recurse должен выводить на экран результат вычисления заданного выражения (пример в условии).
 * 3. Метод recurse не должен быть статическим.
 * 4. Метод recurse должен быть рекурсивным.
 */
public class Solution {
    public Solution() {
        //don't delete
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recurse("sin(2*(-5+1.5*4)+28)", 0); // Expected output: 0.5 6

//        solution.test();
    }

    public void test() {
        recurse("tan(45)", 0);
        System.out.println("1 1 - expected output");
        recurse("tan(-45)", 0);
        System.out.println("-1 2 - expected output");
        recurse("0.305", 0);
        System.out.println("0.3 0 - expected output");
        recurse("0.3051", 0);
        System.out.println("0.31 - expected output");
        recurse("(0.3051)", 0);
        System.out.println("0.31 - expected output");
        recurse("1+(1+(1+1)*(1+1))*(1+1)+1", 0);
        System.out.println("12 8 - expected output");
        recurse("tan(44+sin(89-cos(180)^2))", 0);
        System.out.println("1 6 - expected output");
        recurse("-2+(-2+(-2)-2*(2+2))", 0);
        System.out.println("-14 8 - expected output");
        recurse("sin(80+(2+(1+1))*(1+1)+2)", 0);
        System.out.println("1 7 - expected output");
        recurse("1+4/2/2+2^2+2*2-2^(2-1+1)", 0);
        System.out.println("6 11 - expected output");
        recurse("10-2^(2-1+1)", 0);
        System.out.println("6 4 - expected output");
        recurse("2^10+2^(5+5)", 0);
        System.out.println("2048 4 - expected output");
        recurse("1.01+(2.02-1+1/0.5*1.02)/0.1+0.25+41.1", 0);
        System.out.println("72.96 8 - expected output");
        recurse("0.000025+0.000012", 0);
        System.out.println("0 1 - expected output");
        recurse("-2-(-2-1-(-2)-(-2)-(-2-2-(-2)-2)-2-2)", 0);
        System.out.println("-3 16 - expected output");
        recurse("cos(3 + 19*3)", 0);
        System.out.println("0.5 3 - expected output");
    }

    public void recurse(final String expression, int countOperation) {
        String temp = expression;

        Pattern patternUnaryMinus = Pattern.compile("[^\\d)?]-|^-");
        Pattern patternInnerBrackets = Pattern.compile("\\(([^()]*)\\)");
        Pattern patternReadyMadeBrackets = Pattern.compile("\\((-?[\\d.]+)\\)");
        Pattern patternPow = Pattern.compile("(-?[\\d.]+)(\\^)(-?[\\d.]+)");
        Pattern patternSin = Pattern.compile("()(sin|cos|tan)(-?[\\d.]+)");
        Pattern patternMultiDivision = Pattern.compile("(-?[\\d.]+)([*/])(-?[\\d.]+)");
        Pattern patternAddSub = Pattern.compile("(-?[\\d.]+)?([+M])(-?[\\d.]+)");
        Pattern patternDoublePluses = Pattern.compile("()(--)([\\d.]+)");

        if (countOperation == 0) {
            patternUnaryMinus.matcher(temp);
            temp = temp.replaceAll("-", "M");
        }

        temp = temp.replaceAll(" +", "");
        String calcTemp = temp;

        int start = 0;
        int end = calcTemp.length();
        Matcher mathPar = patternInnerBrackets.matcher(temp);

        if (mathPar.find()) {
            calcTemp = mathPar.group(1);
            start = mathPar.start() + 1;
            end = mathPar.end() - 1;
        }

        String line = temp.length() == end ? "" : temp.substring(end);

        String result = calc(calcTemp, patternSin);
        if (!result.equals("")) {
            countOperation++;
            temp = temp.substring(0, start) + result + line;
            recurse(temp, countOperation);
            return;
        }

        result = calc(calcTemp, patternPow);
        if (!result.equals("")) {
            countOperation++;
            temp = temp.substring(0, start) + result + line;
            recurse(temp, countOperation);
            return;
        }

        result = calc(calcTemp, patternMultiDivision);
        if (!result.equals("")) {
            countOperation++;
            temp = temp.substring(0, start) + result + line;
            recurse(temp, countOperation);
            return;
        }

        result = calc(calcTemp, patternDoublePluses);
        if (!result.equals("")) {
            temp = temp.substring(0, start) + result + line;
            recurse(temp, countOperation);
            return;
        }

        result = calc(calcTemp, patternAddSub);
        if (!result.equals("")) {
            countOperation++;
            temp = temp.substring(0, start) + result + line;
            recurse(temp, countOperation);
            return;
        }

        mathPar = patternReadyMadeBrackets.matcher(temp);
        if (mathPar.find()) {
            temp = temp.substring(0, start - 1) + mathPar.group(1) + temp.substring(end + 1);
            recurse(temp, countOperation);
            return;
        }

        NumberFormat format = new DecimalFormat("#.##");
        Double d = Double.parseDouble(temp);

        System.out.println(String.format("%s %d", format.format(d), countOperation).replace(",", "."));
    }

    private String calc(String temp, Pattern pattern) {

        String result = "";
        Matcher matcher = pattern.matcher(temp);

        if (matcher.find()) {
            result = temp.replaceFirst(pattern.pattern(), numerate(matcher));
        }

        return result;
    }

    private String numerate(Matcher matcher) {
        Map<String, DoubleBinaryOperator> map = new HashMap<>();
        map.put("*", (double a, double b) -> a * b);
        map.put("/", (double a, double b) -> a / b);
        map.put("M", (double a, double b) -> a - b);
        map.put("+", Double::sum);
        map.put("++", (double a, double b) -> b);
        map.put("M-", (double a, double b) -> b);
        map.put("^", Math::pow);
        map.put("cos", (double a, double b) -> Math.cos(Math.toRadians(b)));
        map.put("sin", (double a, double b) -> Math.sin(Math.toRadians(b)));
        map.put("tan", (double a, double b) -> Math.tan(Math.toRadians(b)));

        String left = "0";
        String right = "0";

        try {
            left = matcher.group(1).equals("") ? "0" : matcher.group(1);
        } catch (NullPointerException ignored) {
        }

        try {
            right = matcher.group(3).equals("") ? "0" : matcher.group(3);
        } catch (NullPointerException ignored) {
        }

        double result = map.get(matcher.group(2))
                .applyAsDouble(Double.parseDouble(left), Double.parseDouble(right));

        NumberFormat format = new DecimalFormat("#.##");
        return String.format("%s", format.format(result)).replace(",", ".");
    }

}
