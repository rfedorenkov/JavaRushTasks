package com.javarush.task.task27.task2704;

/**
 * Модификаторы и deadlock
 * Расставь модификаторы так, чтобы при работе с этим кодом появился deadlock.
 * Метод main порождает deadlock, поэтому не участвует в тестировании.
 *
 *
 * Requirements:
 * 1. Поле field должно быть приватным.
 * 2. Метод getField НЕ должен быть приватным.
 * 3. Метод sout должен быть объявлен с модификатором synchronized.
 * 4. Метод sout2 должен быть объявлен с модификатором synchronized.
*/

public class Solution {
    private final String field;

    public Solution(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public synchronized void sout(Solution solution) {
        System.out.format("111:  %s: %s %n", this.field, solution.getField());
        solution.sout2(this);
    }

    public synchronized void sout2(Solution solution) {
        System.out.format("222:  %s: %s %n", this.field, solution.getField());
        solution.sout(this);
    }

    public static void main(String[] args) {
        final Solution solution = new Solution("first");
        final Solution solution2 = new Solution("second");
        new Thread(() -> solution.sout(solution2)).start();
        new Thread(() -> solution2.sout(solution)).start();
    }
}
