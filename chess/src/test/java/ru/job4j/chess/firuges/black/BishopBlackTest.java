package ru.job4j.chess.firuges.black;


import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {

    @Test
    public void whenPosition() {
        BishopBlack bb = new BishopBlack(Cell.E4);
        assertThat(bb.position(), is(Cell.E4));
    }

    @Test
    public void whenCopy() {
        BishopBlack bb = new BishopBlack(Cell.B1);
        Figure bbc = bb.copy(Cell.B3);
        assertThat(bbc.position(), is(Cell.B3));
    }

    @Test
    public void whenWay() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        assertThat(
                bb.way(Cell.C1, Cell.G5),
                is(
                        new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5}
                        )
        );
    }

    @Test (expected = IllegalStateException.class)
    public void whenNoWay() {
        BishopBlack bb = new BishopBlack(Cell.D1);
        bb.way(Cell.D1, Cell.D2);
    }
}
