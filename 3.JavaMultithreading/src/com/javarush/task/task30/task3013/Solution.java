package com.javarush.task.task30.task3013;

/**
 * Битовые операции
 * Необходимо реализовать публичный метод int resetLowerBits(int number),
 * который обнуляет все биты в числе number, кроме самого старшего равного единице, и возвращает это число.
 * Число типа int это 4 байта = 32 бита. Если в метод передано число 3456,
 * его представление в виде битов будет 00000000 00000000 00001101 10000000.
 * В методе нужно обнулить все младшие биты, то есть на выходе ожидается что число,
 * представленное в виде битов, будет иметь вид: 00000000 00000000 00001000 00000000.
 * Это число 2048.
 *
 * Еще несколько примеров:
 * Пример 1:
 * на входе: 1
 * на выходе: 1
 *
 * Пример 2:
 * на входе: 4
 * на выходе: 4
 *
 * Пример 3:
 * на входе: 255
 * на выходе: 128
 *
 * Параметр метода resetLowerBits может быть от 1 до Integer.MAX_VALUE включительно.
 * Используй только операции:
 * 1) =
 * 2) |
 * 3) &
 * 4) >>
 * 5) <<
 * 6) ~
 * 7) цифры от 0 до 9 включительно
 * 8) круглые скобки
 * 9) оператор "return" для возврата результата метода.
 *
 * ЗАПРЕЩЕНО создавать переменные, использовать циклы, условные операторы и прочее.
 * Имя параметра метода resetLowerBits не изменяй (должно быть "number").
 * Метод main не принимает участия в тестировании.
 *
 *
 * Requirements:
 * 1. В классе Solution должен присутствовать публичный метод int resetLowerBits(int).
 * 2. Параметр метода resetLowerBits(int) должен называться number.
 * 3. В классе Solution в методе resetLowerBits(int) используй только разрешенные операции.
 * 4. Метод resetLowerBits должен работать согласно условию задачи.
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int number = Integer.MAX_VALUE - 133;
        System.out.println(Integer.toString(number, 2));

        String result = Integer.toString(solution.resetLowerBits(number), 2);
        System.out.println(result);
    }

    public int resetLowerBits(int number) {
        number |= number >> 1;
        number |= number >> 2;
        number |= number >> 4;
        number |= number >> 8;
        number |= number >> 16;
        return (number & ~number >> 1);
    }
}