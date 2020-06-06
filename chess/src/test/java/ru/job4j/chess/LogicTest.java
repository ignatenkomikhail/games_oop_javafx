package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LogicTest {

    @Test
    public void whenMove() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        boolean rsl = logic.move(Cell.C1, Cell.H6);
        assertThat(rsl, is(true));
    }

    @Test
    public void whenNoMove() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.B1));
        logic.add(new BishopBlack(Cell.E4));
        assertThat(logic.move(Cell.B1, Cell.E4), is(false));
    }
}
