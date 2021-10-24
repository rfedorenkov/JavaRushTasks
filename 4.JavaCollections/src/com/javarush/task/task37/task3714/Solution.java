package com.javarush.task.task37.task3714;

import org.junit.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Древний Рим
 * Амиго, привет! Я недавно увлекся историей вашей планеты и меня заинтересовал период Древнего Рима.
 * Интересно тогда было жить, сплошные развлечения и вино! Или рабство, если не повезло со стартовой локацией...
 *
 * В общем, мне нужен метод romanToInteger, который будет конвертировать
 * число в римской системе счисления {I, V, X, L, C, D, M} в десятичную.
 * Иначе никак не разобрать что и когда у них происходило.
 *
 *
 * Requirements:
 * 1. Метод romanToInteger должен конвертировать число в римской системе счисления в десятичную.
 * 2. Метод romanToInteger должен возвращать значение типа int и принимать один параметр типа String.
 * 3. Метод romanToInteger должен быть публичным.
 * 4. Метод romanToInteger должен быть статическим.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int sum = romanMap.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            Integer integer = romanMap.get(s.charAt(i));
            if (integer >= romanMap.get(s.charAt(i + 1))) {
                sum += integer;
            } else {
                sum -= integer;
            }
        }
        return sum;
    }
}
