package com.javarush.task.task34.task3411;

/**
 * Ханойские башни
 * Имеется три стержня. На стержень A нанизаны numRings колец, причем кольца отличаются размером
 * и лежат меньшее на большем. Требуется перенести пирамиду из numRings колец со стержня A на стержень B
 * за наименьшее число ходов.
 * За один раз разрешается переносить только одно кольцо, причем нельзя класть большее кольцо на меньшее.
 * Нужно реализовать публичный статический метод void moveRing(char a, char b, char c, int numRings),
 * который выведет последовательность действий, необходимых для перемещения колец со стержня A на стержень B.
 *
 * Параметры метода:
 * char a - имя стержня, на котором в начале находятся все кольца;
 * char b - имя стержня, на который нужно перенести все кольца;
 * char c - имя вспомогательного стержня;
 * int numRings - общее количество колец, которые необходимо перенести.
 * Задачу нужно решать используя рекурсивный вызов метода moveRing.
 *
 * Пример1:
 * Метод moveRing вызывается с параметрами: 'A', 'B', 'C', 1
 *
 * Ожидаемый вывод:
 * from A to B
 *
 * Пример2:
 * Метод moveRing вызывается с параметрами: 'A', 'B', 'C', 3
 *
 * Ожидаемый вывод:
 * from A to B
 * from A to C
 * from B to C
 * from A to B
 * from C to A
 * from C to B
 * from A to B
 *
 * Подсказка: общее количество действий равно 2 в степени numRings минус 1.
 *
 *
 * Requirements:
 * 1. В классе Solution должен существовать публичный статический метод void moveRing(char, char, char, int).
 * 2. Методе moveRing должен быть рекурсивным.
 * 3. Количество действий по перемещению колец должно быть равно 2 в степени numRings минус 1.
 * 4. Вывод метода moveRing должен соответствовать условию.
*/

public class Solution {
    public static void main(String[] args) {
        int numRings = 3;
        moveRing('A', 'B', 'C', numRings);
    }

    public static void moveRing(char a, char b, char c, int numRings) {
        if (numRings > 0) {
            moveRing(a, c, b, numRings - 1);
            System.out.printf("from %s to %s%n", a, b);
            moveRing(c, b, a, numRings - 1);
        }
    }

}
