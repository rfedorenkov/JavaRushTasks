package com.javarush.task.task35.task3513;

/**
 * Класс отвечающий за эффективность хода.
 * Реализует интерфейс Comparable.
 *
 * //Очевидно, хороший ход должен в итоге приближать нас к победе, а именно к получению плитки 2048.
 * //
 * //Предлагаю рассмотреть такой вариант сравнения эффективности хода:
 * //1. Первый ход является лучше второго, если после его совершения на поле находится больше пустых плиток,
 * // чем в результате второго хода.
 *
 * //2. Первый ход является лучше второго, если общий счет после его совершения больше, чем счет
 * //полученный в результате второго хода.
 * //
 * //Для того, чтобы реализовать такое сравнение, мы можем совершить ход,
 * // оценить его эффективность и потом отменить совершенный ход, чтобы вернуть игру в начальное состояние.
 * // Применив эту последовательность действий ко всем четырем вариантам хода,
 * // сможем выбрать наиболее эффективный ход и выполнить его.
 */
public class MoveEfficiency implements Comparable<MoveEfficiency>{
    // Количество пустых ячеек
    private int numberOfEmptyTiles;
    // Счет
    private int score;
    // Ход
    private Move move;

    /**
     * Конструктор.
     *
     * @param numberOfEmptyTiles Количество пустых ячеек.
     * @param score Счет.
     * @param move Ход.
     */
    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    /**
     * Геттер move.
     *
     * @return Ход.
     */
    public Move getMove() {
        return move;
    }

    /**
     * Метод сравнивает два объекта MoveEfficiency.
     *
     * @param moveEfficiency Ход другого объекта MoveEfficiency.
     * @return Результат сравнения.
     */
    @Override
    public int compareTo(MoveEfficiency moveEfficiency) {
        // Сраниваем количество пустых плиток
        int compare = Integer.compare(this.numberOfEmptyTiles, moveEfficiency.numberOfEmptyTiles);
        // Если количество одинаково, то сравниваем счет
        return compare == 0 ? Integer.compare(this.score, moveEfficiency.score) : compare;
    }
}