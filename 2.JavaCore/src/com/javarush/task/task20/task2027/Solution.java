package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/**
 * Кроссворд
 * 1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
 * 2. Метод detectAllWords должен найти все слова из words в массиве crossword.
 * 3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
 * text - это само слово, располагается между начальным и конечным элементами
 * 4. Все слова есть в массиве.
 * 5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
 * 6. Метод main не участвует в тестировании.
 *
 *
 * Requirements:
 * 1. В классе Solution должен существовать метод detectAllWords.
 * 2. В классе Solution должен существовать статический класс Word.
 * 3. Класс Solution не должен содержать статические поля.
 * 4. Метод detectAllWords должен быть статическим.
 * 5. Метод detectAllWords должен быть публичным.
 * 6. Метод detectAllWords должен возвращать список всех слов в кроссворде (согласно условию задачи).
 */

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };

        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();
        for (String s : words) {
            for (int j = 0; j < crossword.length; j++) {
                for (int i = 0; i < crossword[j].length; i++) {
                    if (s.charAt(0) == crossword[j][i]) {
                        Word word = new Word(s);
                        word.setStartPoint(i, j);
                        if (wordFound(crossword, word)) {
                            list.add(word);
                        }
                    }
                }
            }
        }
        return list;
    }

    public static boolean wordFound(int[][] crossword, Word word) {
        word.setEndPoint(-1, 0);
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                recursiveWordSearch(crossword, word, word.startX, word.startY, x, y, 1);
                if (word.endX != -1) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void recursiveWordSearch(int[][] crossword, Word word, int startX, int startY, int x, int y, int charNumber) {
        startX += x;
        startY += y;
        if (startY >= 0 && startX >= 0 && startY < crossword.length && startX < crossword[startY].length) {
            if (crossword[startY][startX] == word.text.charAt(charNumber)) {
                if (charNumber == word.text.length() - 1) {
                    word.setEndPoint(startX, startY);
                } else {
                    recursiveWordSearch(crossword, word, startX, startY, x, y, ++charNumber);
                }
            }
        }
    }


    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
