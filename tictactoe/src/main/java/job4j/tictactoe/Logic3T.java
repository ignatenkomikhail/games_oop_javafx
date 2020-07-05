package job4j.tictactoe;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    private boolean filledRows(Figure3T[][] table, Predicate<Figure3T> predicate) {
        boolean rslt = false;
        boolean row = true;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                row &= predicate.test(table[i][j]);
            }
            if (row) {
                rslt = true;
                break;
            }
            row = true;
        }
        return rslt;
    }

    private boolean filledCells(Figure3T[][] table, Predicate<Figure3T> predicate) {
        boolean rslt = false;
        boolean cell = true;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                cell &= predicate.test(table[j][i]);
            }
            if (cell) {
                rslt = true;
                break;
            }
            cell = true;
        }
        return rslt;
    }

    private boolean filledDiagonals(Figure3T[][] table, Predicate<Figure3T> predicate) {
        boolean diagA = true;
        boolean diagB = true;
        for (int i = 0; i < table.length; i++) {
            diagA &= predicate.test(table[i][i]);
            diagB &= predicate.test(table[table.length - 1 - i][i]);
        }
        return diagA || diagB;
    }

    private boolean completed(Figure3T[][] table, Predicate<Figure3T> predicate) {
        return this.filledCells(table, predicate)
                || this.filledDiagonals(table, predicate)
                || this.filledRows(table, predicate);
    }

    public boolean isWinnerX() {
        return this.completed(this.table, Figure3T::hasMarkX);
    }

    public boolean isWinnerO() {
        return this.completed(this.table, Figure3T::hasMarkO);
    }

    public boolean hasGap() {
        return Arrays.stream(this.table)
                .flatMap(Stream::of)
                .anyMatch(e -> e.hasMarkO() == e.hasMarkX());
    }
}
